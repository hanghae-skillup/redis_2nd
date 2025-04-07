package com.pepponechoi.cinema.interceptor;

import com.pepponechoi.cinema.block.service.BlockService;
import com.pepponechoi.cinema.exception.enums.ForbiddenErrorCode;
import com.pepponechoi.cinema.exception.exception.ForbiddenException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
@Slf4j
public class MovieRateLimitInterceptor implements HandlerInterceptor {
    private final BlockService blockService;
    private final RedissonClient redissonClient;

    // 설정값
    private static final int MAX_REQUESTS_PER_MINUTE = 50;
    private static final int BLOCK_DURATION_HOURS = 1;
    private static final double RATE_LIMIT = MAX_REQUESTS_PER_MINUTE / 60.0; // 초당 처리량

    public boolean isAllowed(String ipAddress) {
        // 1. 분당 요청 수 카운터 키
        String requestCountKey = "rate_limit:count:" + ipAddress;

        // 2. 현재 요청 수 증가 (Lua 스크립트 사용하여 원자적 연산)
        Long currentCount = incrementCounter(requestCountKey, 60);

        // 3. 요청 한도 초과 시 IP 차단
        if (currentCount > MAX_REQUESTS_PER_MINUTE) {
            blockIp(ipAddress);
            return false;
        }

        // 4. RateLimiter를 사용하여 초당 속도 제한 적용
        return checkRateLimiter(ipAddress);
    }

    private Long incrementCounter(String key, int expireSeconds) {
        String luaScript =
            "local current = redis.call('incr', KEYS[1])\n" +
                "if current == 1 then\n" +
                "    redis.call('expire', KEYS[1], ARGV[1])\n" +
                "end\n" +
                "return current";

        return executeLuaScript(luaScript, key, String.valueOf(expireSeconds));
    }

    private Long executeLuaScript(String scriptText, String key, String... args) {
        return redissonClient.getScript().eval(
            org.redisson.api.RScript.Mode.READ_WRITE,
            scriptText,
            org.redisson.api.RScript.ReturnType.INTEGER,
            java.util.Collections.singletonList(key),
            (Object[]) args
        );
    }

    private boolean checkRateLimiter(String ipAddress) {
        String rateLimiterKey = "rate_limit:limiter:" + ipAddress;
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(rateLimiterKey);

        // 아직 초기화되지 않은 경우 초기화
        if (!rateLimiter.isExists()) {
            // 설정: 초당 허용 요청 수 (분당 요청 수를 60으로 나눈 값)
            rateLimiter.trySetRate(RateType.OVERALL, MAX_REQUESTS_PER_MINUTE, 1, RateIntervalUnit.MINUTES);
        }

        // 1개의 퍼밋 획득 시도 (비동기 블로킹 없음)
        return rateLimiter.tryAcquire(1);
    }

    private void blockIp(String ipAddress) {
        // IP 차단 정보를 Redis에 저장
        String blockKey = "ip_block:" + ipAddress;
        redissonClient.getBucket(blockKey).set(
            LocalDateTime.now().toString(),
            BLOCK_DURATION_HOURS,
            TimeUnit.HOURS
        );

        // 기존 IP 차단 서비스에도 등록
        blockService.block(ipAddress, LocalDateTime.now().plusHours(BLOCK_DURATION_HOURS));
    }

    /**
     * IP 차단 여부 확인
     */
    public boolean isBlocked(String ipAddress) {
        String blockKey = "ip_block:" + ipAddress;
        return redissonClient.getBucket(blockKey).isExists();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        String ipAddress = getIpAddress(request);

        if (isBlocked(ipAddress)) {
            return false;
        }

        if (!isAllowed(ipAddress)) {
            if (isBlocked(ipAddress)) {
                LocalDateTime blockExpires = LocalDateTime.now().plusHours(1);
                blockService.block(ipAddress, blockExpires);
                ForbiddenException exception = new ForbiddenException();
                exception.setErrorCode(ForbiddenErrorCode.BANNED_IP);
                exception.setDetail("해제 일시 " + blockExpires);
                throw exception;
            } else {
                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                return false;
            }
        }
        return true;
    }

    private String getIpAddress(HttpServletRequest request) {
        String xfHeader = request.getHeader("x-forwarded-for");
        if (xfHeader == null || xfHeader.isEmpty() || "unknown".equalsIgnoreCase(xfHeader)) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
