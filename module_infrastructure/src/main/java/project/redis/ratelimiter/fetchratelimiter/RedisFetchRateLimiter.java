package project.redis.ratelimiter.fetchratelimiter;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component("RedisRateLimiter")
@RequiredArgsConstructor
public class RedisFetchRateLimiter implements FetchRateLimiter {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public Object tryApiCall(LimitRequestPerTime limitRequestPerTime, ProceedingJoinPoint joinPoint) throws Throwable {

        String blockKey = "block_ip:" + limitRequestPerTime.key();
        String blockedIp = redisTemplate.opsForValue().get(blockKey);

        if (blockedIp != null) {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Too many requests");
        }

        TimeUnit timeUnit = limitRequestPerTime.timeUnit();

        String key = "request_count:" + limitRequestPerTime.key();
        String requestCount = redisTemplate.opsForValue().get(key);

        if (requestCount != null) {
            int incrementRequestCount = redisTemplate.opsForValue().increment(key).intValue();
            int limitCount = limitRequestPerTime.limitCount();

            if (incrementRequestCount == limitCount) {
                int blockTime = limitRequestPerTime.blockTime();
                redisTemplate.opsForValue().set(blockKey, "0", blockTime, timeUnit);
                throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Too many requests");
            }
            return joinPoint.proceed();
        }

        int limitTime = limitRequestPerTime.limitTime();
        redisTemplate.opsForValue().set(key, "1", limitTime, timeUnit);
        return joinPoint.proceed();
    }

    @Override
    public void clear() {
        deleteKeysByPattern("block_ip:*");
        deleteKeysByPattern("request_count:*");
    }

    private void deleteKeysByPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys != null && !keys.isEmpty()) {
            redisTemplate.delete(keys);
        }
    }
}
