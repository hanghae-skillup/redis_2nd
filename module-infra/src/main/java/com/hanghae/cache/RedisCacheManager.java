
package com.hanghae.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.Optional;

@RequiredArgsConstructor
public class RedisCacheManager<K, V> implements CacheManager<K, V> {

    private static final Duration DEFAULT_EXPIRE_AFTER_MINUTES = Duration.ofMinutes(10);
    private final RedisTemplate<K, V> cache;

    @Override
    public void put(K key, V value) {
        cache.opsForValue()
                .set(key, value, DEFAULT_EXPIRE_AFTER_MINUTES);
    }

    @Override
    public void put(K key, V value, Duration expireAfter) {
        cache.opsForValue()
                .set(key, value, expireAfter);
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.ofNullable(cache.opsForValue().get(key));
    }

    @Override
    public void remove(K key) {
        cache.delete(key);
    }
}
