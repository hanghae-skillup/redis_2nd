package project.redis.ratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;

public interface RateLimiter {
    Object tryApiCall(LimitRequestPerTime limitRequestPerTime, ProceedingJoinPoint joinPoint)
            throws Throwable;

    void clear();
}
