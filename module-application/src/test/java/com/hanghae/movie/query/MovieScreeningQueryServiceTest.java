package com.hanghae.movie.query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieScreeningQueryServiceTest {
    @Autowired
    private MovieScreeningQueryService movieScreeningQueryService;

    @Test
    void select() {
        List<MovieScreeningDto> showingMovies = movieScreeningQueryService.findShowingMovies();
    }

}