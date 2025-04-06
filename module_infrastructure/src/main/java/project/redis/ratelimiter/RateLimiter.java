package project.redis.ratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;

public interface RateLimiter {
    void tryApiCall(String key, LimitRequestPerTime limitRequestPerTime, ProceedingJoinPoint joinPoint)
            throws Throwable;
}
