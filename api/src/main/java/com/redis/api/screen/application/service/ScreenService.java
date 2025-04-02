package com.redis.api.screen.application.service;

import com.redis.api.screen.application.convert.ScreenNowDetailDtoConvertor;
import com.redis.api.screen.application.dto.ScreenNowDetail;
import com.redis.domain.movie.entity.Genre;
import com.redis.domain.screen.repository.ScreenRepository;
import com.redis.domain.screen.dto.ScreenNowShowDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;

    private final ScreenNowDetailDtoConvertor screenNowDetailDtoConvertor;

    public List<ScreenNowDetail> getMoviesMovieNmLike(String movieNm, Genre genre, String search) {
        LocalDateTime now = LocalDateTime.now();  // 현재 시간 가져오기
        List<ScreenNowShowDto> dbResults = screenRepository.findlikeMovieShowing(movieNm,genre,now);
        List<ScreenNowDetail> movieDetails = screenNowDetailDtoConvertor.moviesNowScreening(dbResults);
        return movieDetails.stream()
                .sorted(Comparator.comparing(ScreenNowDetail::openDate))
                .toList();
    }


}