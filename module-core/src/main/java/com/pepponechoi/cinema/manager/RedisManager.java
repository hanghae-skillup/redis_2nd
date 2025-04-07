package com.pepponechoi.cinema.manager;

import java.util.Optional;

public interface RedisManager {
    <T> Optional<T> getValue(String key);
    <T> void setValue(String key, T value);
    <T> void deleteValue(String key);
    void executeWithLock(String key, Runnable action);
}
