package com.hanghae.cache;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

public interface CacheManager<K, V> {
    void put(K key, V value);
    void put(K key, V value, Duration expireAfter);
    Optional<V> get(K key);
    void remove(K key);
}
