package com.hanghae.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class LocalCacheManager<K, V> implements CacheManager<K, V> {

    private final Cache<K, V> cache;

    public LocalCacheManager(long cacheMaxSize, Duration expireAfterWrite) {
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(expireAfterWrite)
                .maximumSize(cacheMaxSize)
                .build();
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public void put(K key, V value, Duration expireAfter) {
        put(key, value);
        /*************************
         데이터는 내부적으로 ConcurrentHashMap 사용해서 동시성 문제가 없지만
         만료 정책은 별도 관리하기에 동시성 제어가 필요하다고 함
         우선 key로 락 걸도록 수정
         *************************/
        synchronized (key) {
            cache.policy().expireVariably().ifPresent(expiry ->
                    expiry.setExpiresAfter(key, expireAfter.toNanos(), TimeUnit.NANOSECONDS)
            );
        }
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.ofNullable(cache.getIfPresent(key));
    }

    @Override
    public void remove(K key) {
        cache.invalidate(key);
    }

    public int size() {
        return cache.asMap().size();
    }
}
