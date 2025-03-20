package com.hanghae.movie;

import com.hanghae.movie.query.MovieScreeningDto;
import com.hanghae.movie.query.MovieScreeningQueryService;
import com.hanghae.movie.query.MovieScreeningSearchCondition;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieScreeningQueryController {

    private final MovieScreeningQueryService movieScreeningQueryService;

    @PostMapping("/now-showing")
    public List<MovieScreeningDto> findShowingMovies(@Valid @RequestBody MovieScreeningSearchCondition request) {
        return movieScreeningQueryService.findShowingMovies(request);
    }
}
