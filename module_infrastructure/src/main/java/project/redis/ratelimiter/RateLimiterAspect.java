package project.redis.ratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RateLimiterAspect {

    private final RateLimiter rateLimiter;

    public RateLimiterAspect(@Qualifier("GuavaRateLimiter") RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Around("@annotation(limitRequestPerTime)")
    public Object setRateLimiter(ProceedingJoinPoint joinPoint, LimitRequestPerTime limitRequestPerTime)
            throws Throwable {
        return rateLimiter.tryApiCall(limitRequestPerTime, joinPoint);
    }
}
