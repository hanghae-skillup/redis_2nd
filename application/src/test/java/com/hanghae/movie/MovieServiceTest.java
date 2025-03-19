package com.hanghae.movie;

import com.hanghae.common.vo.PositiveNumber;
import com.hanghae.movie.dto.MovieCreateRequest;
import com.hanghae.movie.dto.MovieCreateResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Transactional
@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @DisplayName("영화를 등록한다")
    @Test
    void create() {
        MovieCreateRequest request = new MovieCreateRequest(
                "범죄도시5",
                MovieGrade.TEEN_15,
                LocalDate.of(2025, 3, 14),
                "https://test.com/image.png",
                120,
                MovieGenre.ACTION
        );

        MovieCreateResponse response = movieService.save(request);

        assertAll(
                () -> assertThat(response.id()).isNotNull(),
                () -> assertThat(response.title()).isEqualTo("범죄도시5"),
                () -> assertThat(response.grade()).isEqualTo(MovieGrade.TEEN_15),
                () -> assertThat(response.releaseDate()).isEqualTo(LocalDate.of(2025, 3, 14)),
                () -> assertThat(response.thumbnailUrl()).isEqualTo(new UrlString("https://test.com/image.png")),
                () -> assertThat(response.runningTime()).isEqualTo(new PositiveNumber(120)),
                () -> assertThat(response.genre()).isEqualTo(MovieGenre.ACTION)
        );
    }
}
