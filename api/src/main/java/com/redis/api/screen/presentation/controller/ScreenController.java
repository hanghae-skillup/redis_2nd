package com.redis.api.screen.presentation.controller;

import com.redis.api.screen.application.dto.ScreenNowDetail;
import com.redis.api.screen.application.service.ScreenService;
import com.redis.domain.movie.entity.Genre;
import com.redis.common.util.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;


    //--------레디스 캐시 미사용----------------------------------------------//
    @GetMapping("movies/likeMovie")
    public BaseResponse<List<ScreenNowDetail>> getLikeMovie(
            @RequestParam(value = "movieNm", required = false) String movieNm,
            @RequestParam(value = "genre", required = false) Genre genre,
            @RequestParam(value = "search", required = false)String search
    ) {
        List<ScreenNowDetail> response = screenService.getMoviesMovieNmLike(movieNm ,genre ,search);
        return new BaseResponse<>(response);
    }


}
