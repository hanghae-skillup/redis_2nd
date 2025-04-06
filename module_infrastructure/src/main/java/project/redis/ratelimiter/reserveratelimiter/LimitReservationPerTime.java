package project.redis.ratelimiter.reserveratelimiter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LimitReservationPerTime {

    String userId();

    String screeningId();

    /**
     * 차단 시간
     */
    int blockTime() default 5;

    /**
     * 시간 단위
     */
    TimeUnit timeUnit() default TimeUnit.MINUTES;
}
