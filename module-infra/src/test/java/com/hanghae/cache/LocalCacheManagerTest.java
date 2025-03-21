package com.hanghae.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class LocalCacheManagerTest {

    private LocalCacheManager<String, String> cacheManager;

    @BeforeEach
    void setUp() {
        cacheManager = new LocalCacheManager<String, String>(1_000, Duration.ofMinutes(10));
    }

    @DisplayName("저장된 로컬 캐시의 수를 센다")
    @Test
    void size(){
        cacheManager.put("key1", "value1");
        cacheManager.put("key2", "value2");
        cacheManager.put("key3", "value3");

        assertThat(cacheManager.size()).isEqualTo(3);
    }

    @DisplayName("key-value를 입력하여 로컬 캐시를 저장한다")
    @Test
    void put(){
        cacheManager.put("key1", "value1");
        cacheManager.put("key2", "value2");

        assertThat(cacheManager.size()).isEqualTo(2);
    }
    
    @DisplayName("key를 통해 캐시의 value를 조회한다")
    @Test
    void get(){
        cacheManager.put("key1", "value1");

        String value1 = cacheManager.get("key1")
                .orElseThrow(NoSuchElementException::new);
        Optional<String> value2 = cacheManager.get("key2");

        assertThat(value1).isEqualTo("value1");
        assertThat(value2).isNotPresent();
    }

    @DisplayName("key로 캐시의 value를 제거할 수 있다")
    @Test
    void delete(){
        cacheManager.put("key1", "value1");

        cacheManager.remove("key1");

        assertThat(cacheManager.size()).isZero();
        assertThat(cacheManager.get("key1")).isNotPresent();
    }
}
