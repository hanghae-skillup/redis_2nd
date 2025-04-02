package com.redis.api.screen.application.dto;


import com.redis.domain.movie.entity.Genre;
import com.redis.domain.movie.entity.Grade;

import java.time.LocalDateTime;
import java.util.List;

public record ScreenNowDetail(
        Long movieId,
        String movieNm,
        Grade grade,
        LocalDateTime openDate,
        String imgNm,
        String imgPath,
        Genre genreCd,
        Integer showTimeMin,
        Boolean showYn,
        Boolean screenShowYn,
        List<ScreenDetail> screenDetail
) {
}