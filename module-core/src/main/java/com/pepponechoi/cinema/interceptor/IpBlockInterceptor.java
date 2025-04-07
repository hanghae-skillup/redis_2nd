package com.pepponechoi.cinema.interceptor;

import com.pepponechoi.cinema.block.service.BlockService;
import com.pepponechoi.cinema.blockIps.entity.Block;
import com.pepponechoi.cinema.exception.enums.ForbiddenErrorCode;
import com.pepponechoi.cinema.exception.exception.ForbiddenException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
@Slf4j
public class IpBlockInterceptor implements HandlerInterceptor {
    private final BlockService blockService;
    private final RedissonClient redisson;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        String ip = getIpAddress(request);

        if (isBlockedInRedis(ip)) {
            log.warn("Redis에서 차단된 IP 감지: {}", ip);
            Block block = blockService.getBlock(ip);
            throwBlockedException(block != null ? block.getExpireTime().toString() : "알 수 없음");
        }

        Block block = blockService.getBlock(ip);
        if (block != null) {
            log.warn("DB에서 차단된 IP 감지: {}", ip);
            syncBlockToRedis(ip, block);
            throwBlockedException(block.getExpireTime().toString());
        }

        return true;
    }

    private boolean isBlockedInRedis(String ip) {
        String blockKey = "ip_block:" + ip;
        return redisson.getBucket(blockKey).isExists();
    }

    private void syncBlockToRedis(String ip, Block block) {
        if (block != null && block.getExpireTime() != null) {
            String blockKey = "ip_block:" + ip;

            // 현재 시간이 만료 시간보다 이전인 경우에만 저장
            if (block.getExpireTime().isAfter(java.time.LocalDateTime.now())) {
                long secondsUntilExpiration = java.time.Duration.between(
                    java.time.LocalDateTime.now(),
                    block.getExpireTime()
                ).getSeconds();

                redisson.getBucket(blockKey).set(
                    block.getExpireTime().toString(),
                    secondsUntilExpiration,
                    java.util.concurrent.TimeUnit.SECONDS
                );

                log.info("IP {} 차단 정보 Redis에 동기화됨, 만료: {}", ip, block.getExpireTime());
            }
        }
    }

    private void throwBlockedException(String expireTimeStr) {
        ForbiddenException forbiddenException = new ForbiddenException();
        forbiddenException.setErrorCode(ForbiddenErrorCode.BANNED_IP);
        forbiddenException.setDetail("해제 일시 " + expireTimeStr);
        throw forbiddenException;
    }

    private String getIpAddress(HttpServletRequest request) {
        String xfHeader = request.getHeader("x-forwarded-for");
        if (xfHeader == null || xfHeader.isEmpty() || "unknown".equalsIgnoreCase(xfHeader)) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
