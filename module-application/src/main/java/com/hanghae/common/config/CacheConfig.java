package com.hanghae.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hanghae.cache.CacheManager;
import com.hanghae.cache.LocalCacheManager;
import com.hanghae.cache.RedisCacheManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@EnableCaching
@Configuration
@RequiredArgsConstructor
public class CacheConfig {

    //region [로컬캐시 설정]
    @Value("${cache.local.max-size}")
    private long localCacheMaxSize;

    @Value("${cache.local.expire-after-write}")
    private Duration localCacheDefaultExpireAfterWrite;
    //endregion

    //region [글로벌캐시설정]
    @Value("${spring.data.redis.host}")
    private String globalCacheHost;

    @Value("${spring.data.redis.port}")
    private int globalCachePort;
    //endregion

    //region [로컬캐시]
    @Primary
    @Bean
    public CacheManager<String, Object> localCache() {
        return new LocalCacheManager<>(localCacheMaxSize, localCacheDefaultExpireAfterWrite);
    }
    //endregion

    //region [글로벌캐시]
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration();
        redisConfiguration.setHostName(globalCacheHost);
        redisConfiguration.setPort(globalCachePort);
        return new LettuceConnectionFactory(redisConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();

        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        return redisTemplate;
    }

    //@Primary
    @Bean
    public CacheManager<String, Object> globalCache() {
        return new RedisCacheManager<>(redisTemplate());
    }
    //endregion
}
