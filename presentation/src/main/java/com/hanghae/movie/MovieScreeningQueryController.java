package com.hanghae.movie;

import com.hanghae.movie.query.MovieScreeningDto;
import com.hanghae.movie.query.MovieScreeningQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieScreeningQueryController {

    private final MovieScreeningQueryService movieScreeningQueryService;

    @GetMapping("/now-showing")
    public List<MovieScreeningDto> findShowingMovies() {
        return movieScreeningQueryService.findShowingMovies();
    }
}