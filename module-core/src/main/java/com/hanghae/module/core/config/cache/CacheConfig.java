package com.hanghae.module.core.config.cache;

import com.hanghae.module.common.enums.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class CacheConfig {
  @Bean("movieCacheKeyGenerator")
  public KeyGenerator loggingKeyGenerator() {
    return new LoggingKeyGenerator();
  }

  public static class LoggingKeyGenerator implements KeyGenerator {

    private static final Logger log = LoggerFactory.getLogger(LoggingKeyGenerator.class);

    @Override
    public Object generate(Object target, Method method, Object... params) {
      Long theaterId = params[0] != null ? (Long) params[0] : null;
      String title = params[1] != null ? (String) params[1] : null;
      Genre genre = params[2] != null ? (Genre) params[2] : null;

      String key = (theaterId == null ? "all" : theaterId) + ":" +
        (title == null ? "all" : title) + ":" +
        (genre == null ? "all" : genre);

      log.info("Generated cache key: {}", key);
      return key;
    }
  }
}
