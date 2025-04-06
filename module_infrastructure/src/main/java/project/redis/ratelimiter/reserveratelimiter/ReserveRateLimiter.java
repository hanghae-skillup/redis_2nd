package project.redis.ratelimiter.reserveratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;

public interface ReserveRateLimiter {
    Object tryApiCall(LimitReservationPerTime limitReservationPerTime, ProceedingJoinPoint joinPoint)
            throws Throwable;

    void clear();
}
