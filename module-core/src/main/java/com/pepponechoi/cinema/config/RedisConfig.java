package com.pepponechoi.cinema.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {
    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;

    private static final String REDISSON_HOST_PRREFIX = "redis://";

    @Bean
    public RedissonClient redissonClient() {
        RedissonClient redissonClient = null;
        Config config = new Config();
        config.useSingleServer().setAddress(REDISSON_HOST_PRREFIX + REDIS_HOST + ":" + REDIS_PORT);
        redissonClient = Redisson.create(config);
        return redissonClient;
    }

    @Bean
    public RedissonConnectionFactory redissonConnectionFactory(RedissonClient redissonClient) {
        return new RedissonConnectionFactory(redissonClient);
    }

    @Bean
    public RedisTemplate<String, Object> objectRedisTemplate(RedissonConnectionFactory redissonConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        PolymorphicTypeValidator typeValidator = BasicPolymorphicTypeValidator
            .builder()
            .allowIfSubType(Object.class)            .build();
        ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule()) // LocalDateTime 지원
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // ISO-8601 포맷 사용
            .activateDefaultTyping(
                typeValidator, DefaultTyping.NON_FINAL
            );
        redisTemplate.setConnectionFactory(redissonConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));

        return redisTemplate;
    }
}
