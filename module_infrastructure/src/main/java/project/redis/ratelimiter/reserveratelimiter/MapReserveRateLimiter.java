package project.redis.ratelimiter.reserveratelimiter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component("MapReserveRateLimiter")
@RequiredArgsConstructor
public class MapReserveRateLimiter implements ReserveRateLimiter {

    private static final Map<String, LocalDateTime> reservedTimeForUser = new ConcurrentHashMap<>();

    @Override
    public Object tryApiCall(LimitReservationPerTime limitReservationPerTime, ProceedingJoinPoint joinPoint)
            throws Throwable {
        String userId = limitReservationPerTime.userId();
        String screeningId = limitReservationPerTime.screeningId();

        String key = userId + "_" + screeningId;

        LocalDateTime now = LocalDateTime.now();

        if (reservedTimeForUser.containsKey(key)) {
            LocalDateTime reservedTime = reservedTimeForUser.get(key);
            Duration duration = Duration.between(reservedTime, now);

            long diffMinutes = duration.toMinutes();
            int blockTime = limitReservationPerTime.blockTime();

            if (diffMinutes <= blockTime) {
                throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Too many requests");
            }
        }
        reservedTimeForUser.put(key, now);
        return joinPoint.proceed();
    }

    @Override
    public void clear() {
        reservedTimeForUser.clear();
    }
}
