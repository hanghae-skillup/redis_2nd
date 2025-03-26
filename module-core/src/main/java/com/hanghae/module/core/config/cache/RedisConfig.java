package com.hanghae.module.core.config.cache;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnProperty(name = "spring.cache.type", havingValue = "redis")
public class RedisConfig {

  @Value("${spring.data.redis.host:localhost}")
  private String redisHost;

  @Value("${spring.data.redis.port:6379}")
  private int redisPort;

  @Value("${spring.cache.ttl:600}")
  private int cacheTtl;

  @Bean
  public RedissonClient redissonClient() {
    Config config = new Config();
    config.useSingleServer()
      .setAddress("redis://" + redisHost + ":" + redisPort);

    return Redisson.create(config);
  }

  @Bean
  @Primary
  public CacheManager redisCacheManager(RedissonClient redissonClient) {
    Map<String, org.redisson.spring.cache.CacheConfig> config = new HashMap<>();

    // TTL 설정 (밀리초 단위로 변환)
    int ttlMillis = cacheTtl * 1000;
    config.put("movies", new org.redisson.spring.cache.CacheConfig(ttlMillis, ttlMillis / 2));


    return new RedissonSpringCacheManager(redissonClient, config);
  }
}
