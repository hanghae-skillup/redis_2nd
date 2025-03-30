package com.hanghae.lock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Component
@Slf4j
@RequiredArgsConstructor
public class DistributedLockManager {

    private static final long DEFAULT_WAIT_TIME = 5L;
    private static final long DEFAULT_LEASE_TIME = 30L;

    private final RedissonClient redissonClient;

    public <T> T executeWithLock(String lockName, Supplier<T> action) {
        RLock lock = redissonClient.getLock(lockName);

        try {
            log.info("redisson 락 획득 start - 락 이름 : {}", lockName);
            if (lock.tryLock(DEFAULT_WAIT_TIME, DEFAULT_LEASE_TIME, TimeUnit.MINUTES)) {
                try {
                    return action.get();
                } finally {
                    if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                        lock.unlock();
                        log.info("redisson 락 해제 - 락 이름 : {}", lockName);
                    }
                }
            }
            throw new RuntimeException("Distributed Lock 획득 실패: " + lockName);
        } catch (InterruptedException e) {
            throw new RuntimeException("Distributed Lock 중단됨: " + lockName, e);
        }
    }

    public void executeWithLock(String lockName, Runnable action) {
        executeWithLock(lockName, () -> {
            action.run();
            return null;
        });
    }
}