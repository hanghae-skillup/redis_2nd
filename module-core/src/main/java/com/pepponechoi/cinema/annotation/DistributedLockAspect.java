package com.pepponechoi.cinema.annotation;

import com.pepponechoi.cinema.exception.enums.DistributedLockErrorCode;
import com.pepponechoi.cinema.exception.exception.DistributedLockException;
import java.lang.reflect.Method;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class DistributedLockAspect {
    private final RedissonClient redisson;
    private final RequireNewTransactionAspect requireNewTransactionAspect;

    private static final String LOCK_KEY_PREFIX = "LOCK:";

    @Pointcut("@annotation(distributedLock)")
    public void pointCut(DistributedLock distributedLock) {

    }

    @Around(value = "pointCut(distributedLock)", argNames = "pjp,distributedLock")
    public Object around(ProceedingJoinPoint pjp, DistributedLock distributedLock) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        String key = LOCK_KEY_PREFIX + distributedLock.key();

        RLock rLock = redisson.getLock(key);

        try {
            boolean available = rLock.tryLock(distributedLock.waitTime(),
                distributedLock.leaseTime(), distributedLock.timeUnit());
            if (!available) {
                DistributedLockException distributedLockException = new DistributedLockException();
                distributedLockException.setErrorCode(DistributedLockErrorCode.DISTRIBUTED_LOCK_ERROR);
                distributedLockException.setDetail("락 획득을 실패하였습니다.");
                throw distributedLockException;
            }
            return requireNewTransactionAspect.proceed(pjp);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            DistributedLockException distributedLockException = new DistributedLockException();
            distributedLockException.setErrorCode(DistributedLockErrorCode.DISTRIBUTED_LOCK_ERROR);
            distributedLockException.setDetail("락 획득 중 인터럽트가 발생하였습니다.");
            throw distributedLockException;
        } finally {
            if (rLock.isLocked() || rLock.isHeldByCurrentThread()) {
                rLock.unlock();
            }
        }
    }
}
