package com.pepponechoi.cinema.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String CACHE_NEXT_DAY = "cachenextday";

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory, ResourceLoader resourceLoader) {
        RedisCacheManager.RedisCacheManagerBuilder builder =
            RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory);

        ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule()) // LocalDateTime 지원
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // ISO-8601 포맷 사용
            .activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL, // 모든 비-기본 타입에 대해 타입 정보 활성화
                JsonTypeInfo.As.PROPERTY // 타입 정보를 속성으로 포함
            );

        RedisCacheConfiguration defaultCacheConfiguration =
            RedisCacheConfiguration.defaultCacheConfig(resourceLoader.getClassLoader())
                .disableCachingNullValues()
                .serializeValuesWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(SerializationPair.fromSerializer(
                    new GenericJackson2JsonRedisSerializer(objectMapper)
                ))
                .entryTtl(Duration.ofDays(1));
        Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
        cacheConfigurationMap.put(CACHE_NEXT_DAY,
            defaultCacheConfiguration.entryTtl(getDurationUntilMidnight()));
        return builder.cacheDefaults(defaultCacheConfiguration)
            .withInitialCacheConfigurations(cacheConfigurationMap).build();
    }

    private Duration getDurationUntilMidnight() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime midnight = now.plusDays(1).withHour(0).withMinute(0).withSecond(0);
        return Duration.between(midnight, now);
    }
}
