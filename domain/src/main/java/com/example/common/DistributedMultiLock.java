package com.example.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DistributedMultiLock {
    String expression();
    long waitTime() default 2000L;      // milliseconds
    long leaseTime() default 1500L;     // milliseconds
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}