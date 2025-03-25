package com.redis.movie.presentation.controller;

import com.redis.movie.application.dto.MoviesNowShowingDetail;
import com.redis.movie.application.service.MovieService;
import com.redis.movie.entity.movie.Genre;
import com.redis.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("v1/movies/nowMovie")
    public BaseResponse<List<MoviesNowShowingDetail>> getMoviesNowShowing(
            @RequestParam(value = "genre", required = false) Genre genre,
            @RequestParam(value = "movieNm", required = false) String movieNm,
            @RequestParam(value = "search", required = false)String search
    ) {
        List<MoviesNowShowingDetail> response = movieService.getMoviesNowShowing(LocalDateTime.now(),movieNm, genre, search);
        return new BaseResponse<>(response);
    }

}
