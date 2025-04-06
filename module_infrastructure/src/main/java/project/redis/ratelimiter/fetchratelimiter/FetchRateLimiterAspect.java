package project.redis.ratelimiter.fetchratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FetchRateLimiterAspect {

    private final FetchRateLimiter fetchRateLimiter;

    public FetchRateLimiterAspect(@Qualifier("MapRateLimiter") FetchRateLimiter fetchRateLimiter) {
        this.fetchRateLimiter = fetchRateLimiter;
    }

    @Around("@annotation(limitRequestPerTime)")
    public Object setRateLimiter(ProceedingJoinPoint joinPoint, LimitRequestPerTime limitRequestPerTime)
            throws Throwable {
        return fetchRateLimiter.tryApiCall(limitRequestPerTime, joinPoint);
    }
}
