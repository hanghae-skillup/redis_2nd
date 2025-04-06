package project.redis.ratelimiter.reserveratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReserveRateLimiterAspect {

    private final ReserveRateLimiter reserveRateLimiter;

    public ReserveRateLimiterAspect(@Qualifier("MapReserveRateLimiter") ReserveRateLimiter reserveRateLimiter) {
        this.reserveRateLimiter = reserveRateLimiter;
    }

    @Around("@annotation(limitReservationPerTime)")
    public Object setRateLimiter(ProceedingJoinPoint joinPoint, LimitReservationPerTime limitReservationPerTime)
            throws Throwable {
        return reserveRateLimiter.tryApiCall(limitReservationPerTime, joinPoint);
    }
}
