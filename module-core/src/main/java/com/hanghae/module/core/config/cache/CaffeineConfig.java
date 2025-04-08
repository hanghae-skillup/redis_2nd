package com.hanghae.module.core.config.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnProperty(name = "spring.cache.type", havingValue = "caffeine", matchIfMissing = true)
public class CaffeineConfig {
  private static final Logger log = LoggerFactory.getLogger(CaffeineConfig.class);

  @Value("${spring.cache.ttl:600}")
  private int cacheTtl;

  @Value("${spring.cache.max-size:500}")
  private int cacheMaxSize;

  @Bean
  @Primary
  public CacheManager caffeineCacheManager() {
    log.info("Caffeine cache manager start");
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setCacheNames(List.of("movies"));
    cacheManager.setCaffeine(Caffeine.newBuilder()
      .expireAfterWrite(cacheTtl, TimeUnit.SECONDS)
      .maximumSize(cacheMaxSize)
      .recordStats());
    return cacheManager;
  }
}
