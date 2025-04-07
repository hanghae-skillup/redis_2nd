package com.pepponechoi.cinema.config;

import com.pepponechoi.cinema.interceptor.IpBlockInterceptor;
import com.pepponechoi.cinema.interceptor.MovieRateLimitInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final IpBlockInterceptor ipBlockInterceptor;
    private final MovieRateLimitInterceptor movieRateLimitInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipBlockInterceptor)
            .addPathPatterns("/api/v1/**");
        registry.addInterceptor(movieRateLimitInterceptor)
            .addPathPatterns("/api/v1/movies/**");
    }
}
