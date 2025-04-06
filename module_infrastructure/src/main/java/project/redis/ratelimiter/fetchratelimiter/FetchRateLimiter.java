package project.redis.ratelimiter.fetchratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;

public interface FetchRateLimiter {
    Object tryApiCall(LimitRequestPerTime limitRequestPerTime, ProceedingJoinPoint joinPoint)
            throws Throwable;

    void clear();
}
