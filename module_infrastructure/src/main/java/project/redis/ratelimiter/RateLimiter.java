package project.redis.ratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;

public interface RateLimiter {
    void tryApiCall(LimitRequestPerTime limitRequestPerTime, ProceedingJoinPoint joinPoint)
            throws Throwable;
}
