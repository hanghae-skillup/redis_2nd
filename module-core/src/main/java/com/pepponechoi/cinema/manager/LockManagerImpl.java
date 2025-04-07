package com.pepponechoi.cinema.manager;

import com.pepponechoi.cinema.exception.enums.ConfliectErrorCode;
import com.pepponechoi.cinema.exception.exception.ConflictException;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LockManagerImpl implements RedisManager {

    private final RedissonClient redisson;

    private final String LOCK_SUFFIX = "lock";
    private final Long WAIT_TIME_SECONDS = 5L;
    private final Long LEASE_TIME_SECONDS = 3L;

    @Override
    public <T> Optional<T> getValue(String key) {
        RBucket<T> bucket = redisson.getBucket(key);
        if (bucket.isExists()) {
            return Optional.of(bucket.get());
        }
        return Optional.empty();
    }

    @Override
    public <T> void setValue(String key, T value) {
        redisson.getBucket(key).set(value);
    }

    @Override
    public <T> void deleteValue(String key) {
        if (redisson.getBucket(key).isExists()) {
            redisson.getBucket(key).delete();
        }
    }

    @Override
    public void executeWithLock(String key, Runnable action) {
        RLock lock = redisson.getLock(key + LOCK_SUFFIX);

        try {
            boolean isLocked = tryLockWithRetry(lock, WAIT_TIME_SECONDS, LEASE_TIME_SECONDS);
            if (isLocked) {
                // 잠금 획득에 성공하면 작업 실행
                action.run();
            } else {
                // 잠금 획득 실패 시 예외 발생
                ConflictException exception = new ConflictException();
                exception.setErrorCode(ConfliectErrorCode.CONFLICT);
                exception.setDetail("록 획득에 실패하였습니다.");
                throw exception;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            ConflictException exception = new ConflictException();
            exception.setErrorCode(ConfliectErrorCode.CONFLICT);
            exception.setDetail("록 획득중 인터럽트 되었습니다.");
            throw exception;
        } finally {
            unlock(lock);
        }
    }

    private boolean tryLockWithRetry(RLock lock, long waitTime, long leaseTime) throws InterruptedException {
        final int MAX_RETRIES = 3;
        final int INITIAL_RETRY_DELAY_MS = 100;
        final long MAX_RETRY_DELAY_MS = 1000;
        final Random random = new Random();

        int retryCount = 0;
        while (retryCount <= MAX_RETRIES) {
            boolean isLocked = lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
            if (isLocked) {
                return true;
            }
            retryCount++;
            if (retryCount <= MAX_RETRIES) {
                long delay = INITIAL_RETRY_DELAY_MS * (long) Math.pow(2, retryCount - 1);
                delay = Math.min(delay, MAX_RETRY_DELAY_MS);

                int jitterRange = (int)(delay * 0.4);
                int jitter = random.nextInt(jitterRange) - (int)(delay * 0.2);
                delay += jitter;

                Thread.sleep(Math.max(delay, INITIAL_RETRY_DELAY_MS));
            }
        }
        return false;
    }

    private void unlock(RLock lock) {
        if (lock.isHeldByCurrentThread() && lock.isLocked()) {
            lock.unlock();
        }
    }
}
