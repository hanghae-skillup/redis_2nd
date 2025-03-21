package com.hanghae.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class RedisCacheManagerTest {

    private RedisTemplate<String, String> redisTemplate;
    private RedisCacheManager<String, String> cacheManager;

    @BeforeEach
    void setUp() {
        RedisTemplate<String, String> embeddedRedisTemplate = createEmbeddedRedisTemplate();
        cacheManager = new RedisCacheManager<>(embeddedRedisTemplate);
    }

    @DisplayName("key를 통해 value를 조회한다")
    @Test
    void get() {
        cacheManager.put("key1", "value1");

        String value1 = cacheManager.get("key1")
                .orElseThrow(NoSuchElementException::new);

        String valueByRedis = redisTemplate.opsForValue().get("key1");
        assertThat(value1).isEqualTo(valueByRedis);
    }

    @DisplayName("key-value를 입력하여 레디스에 저장한다")
    @Test
    void put() {
        cacheManager.put("key1", "value1");

        String value = cacheManager.get("key1")
                .orElseThrow(NoSuchElementException::new);

        assertThat(value).isEqualTo("value1");
    }

    @DisplayName("key를 통해 value를 제거한다")
    @Test
    void remove() {
        cacheManager.put("key1", "value1");

        cacheManager.remove("key1");

        Optional<String> value = cacheManager.get("key1");
        assertThat(value).isNotPresent();
    }

    private RedisTemplate<String, String> createEmbeddedRedisTemplate() {
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory("localhost", 6379);
        connectionFactory.afterPropertiesSet();

        redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }
}
