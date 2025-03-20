package com.hanghae.movie.query;

import com.hanghae.SearchCriteria;
import com.hanghae.common.enums.SearchMatchType;
import com.hanghae.movie.MovieGenre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieScreeningQueryServiceTest {

    @Autowired
    private MovieScreeningQueryService movieScreeningQueryService;

    @DisplayName("상영 중인 영화 목록에서 영화 이름, 장르 필터링하여 조회 한다")
    @Test
    void select() {
        MovieScreeningSearchCondition condition = MovieScreeningSearchCondition.builder()
                .movieName(new SearchCriteria<String>("타이타닉", SearchMatchType.EQUAL))
                .genre(List.of(MovieGenre.ROMANCE))
                .build();

        List<MovieScreeningDto> showingMovies = movieScreeningQueryService.findShowingMovies(condition);
    }

}