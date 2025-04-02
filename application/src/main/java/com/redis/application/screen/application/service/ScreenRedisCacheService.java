package com.redis.application.screen.application.service;

import com.redis.domain.movie.entity.Genre;
import com.redis.domain.screen.dto.ScreenNowShowDto;
import com.redis.domain.screen.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenRedisCacheService {

    private final ScreenRepository screenRepository;

    //레디스 캐시 사용
    @Cacheable(value = "screenCache", key = "#movieNm + ':' + #genre")
    public List<ScreenNowShowDto> getScreengings(String movieNm, Genre genre) {
        LocalDateTime now = LocalDateTime.now();
        // 현재 시간 이후로 상영 중인 영화 조회
        return screenRepository.findlikeMovieShowing(movieNm, genre, LocalDateTime.now());
    }
}



