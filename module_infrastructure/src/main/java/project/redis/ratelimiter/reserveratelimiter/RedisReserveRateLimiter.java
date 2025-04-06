package project.redis.ratelimiter.reserveratelimiter;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component("RedisReserveRateLimiter")
@RequiredArgsConstructor
public class RedisReserveRateLimiter implements ReserveRateLimiter {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public Object tryApiCall(LimitReservationPerTime limitReservationPerTime, ProceedingJoinPoint joinPoint)
            throws Throwable {

        String userId = limitReservationPerTime.userId();
        String screeningId = limitReservationPerTime.screeningId();

        String key = "rate_limit:" + userId + "_" + screeningId;

        int blockTime = limitReservationPerTime.blockTime();
        TimeUnit timeUnit = limitReservationPerTime.timeUnit();

        String reservedTimeStr = redisTemplate.opsForValue().get(key);

        if (reservedTimeStr != null) {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Too many requests");
        }

        redisTemplate.opsForValue().set(key, "0", blockTime, timeUnit);

        return joinPoint.proceed();
    }

    @Override
    public void clear() {
        Set<String> keys = redisTemplate.keys("rate_limit:*");
        if (keys != null && !keys.isEmpty()) {
            redisTemplate.delete(keys);
        }
    }
}
