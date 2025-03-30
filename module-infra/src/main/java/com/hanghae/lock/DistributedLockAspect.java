package com.hanghae.lock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class DistributedLockAspect {

    private final RedissonClient redissonClient;

    @Around("@annotation(com.hanghae.lock.DistributedLock)")
    public Object lock(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        DistributedLock distributedLock = method.getAnnotation(DistributedLock.class);

        String lockName = distributedLock.name();
        String generatedLockName = generateLockName(lockName);
        RLock rLock = redissonClient.getLock(generatedLockName);

        long waitTime = distributedLock.waitTime();
        long leaseTime = distributedLock.leaseTime();
        TimeUnit timeUnit = distributedLock.timeUnit();

        try {
            log.info("redisson 락 획득 start - 락 이름 : {}", generatedLockName);
            boolean isLocked = rLock.tryLock(waitTime, leaseTime, timeUnit);
            if (!isLocked) {
                throw new IllegalStateException("lock 획득 실패 : " + generatedLockName);
            }
            log.info("redisson 락 획득 성공 end - 락 이름 : {}", generatedLockName);
            return joinPoint.proceed();
        } catch (Exception e) {
            throw e;
        } finally {
            if (rLock.isLocked() && rLock.isHeldByCurrentThread()) {
                try {
                    rLock.unlock();
                    log.info("redisson 락 해제 - 락 이름 : {}", generatedLockName);
                } catch (Exception e) {
                    log.error("redisson 락 해제 중 예외 발생 - 락 이름 : {}", generatedLockName, e);
                }
            }
        }
    }

    private String generateLockName(String lockName) {
        return "%s:%s".formatted(lockName, System.currentTimeMillis());
    }
}
