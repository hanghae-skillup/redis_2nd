package project.redis.ratelimiter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LimitRequestPerTime {

    String key();

    /**
     * 차단 시간
     */
    int blockTime() default 60;

    /**
     * 요청 횟수 체크할 시간
     */
    int limitTime() default 1;

    /**
     * 시간 당 최대 요청 횟수
     */
    int limitCount() default 50;

    /**
     * 시간 단위
     */
    TimeUnit timeUnit() default TimeUnit.MINUTES;


}