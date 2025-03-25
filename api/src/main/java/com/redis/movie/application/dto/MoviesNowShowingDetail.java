package com.redis.movie.application.dto;


import com.redis.movie.entity.movie.Genre;
import com.redis.movie.entity.movie.Grade;

import java.time.LocalDateTime;
import java.util.List;

public record MoviesNowShowingDetail (
        String movieId,
        String movieNm,
        Grade grade,
        LocalDateTime openDt,
        String imgNm,
        String imgPath,
        Genre genreCd,
        int showTm,
        String showYn,
        String screenShowYn,
        List<ScreenDetail> screenDetail
) {
}