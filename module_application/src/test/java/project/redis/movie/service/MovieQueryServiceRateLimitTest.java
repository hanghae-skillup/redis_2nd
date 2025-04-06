package project.redis.movie.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;
import project.redis.CinemaApplication;
import project.redis.movie.dto.NowPlayMovieDto;
import project.redis.ratelimiter.fetchratelimiter.FetchRateLimiter;

@SpringBootTest(classes = CinemaApplication.class)
class MovieQueryServiceRateLimitTest {

    @Autowired
    private MovieQueryService movieQueryService;

    @Autowired
    private FetchRateLimiter fetchRateLimiter;

    @BeforeEach
    void clear() {
        fetchRateLimiter.clear();
    }

    @DisplayName("1분에 50회 이상 조회한 IP는 예외와 함께 차단 당한다.")
    @Test
    void getNowPlayingMoviesRateLimitTest() {
        // given
        int maxIterCount = 50;

        for (int i = 0; i < maxIterCount - 1; i++) {
            movieQueryService.getNowPlayingMovies(null, null, "1234");
        }

        // when then
        assertThatThrownBy(() -> movieQueryService.getNowPlayingMovies(null, null, "1234"))
                .isInstanceOf(ResponseStatusException.class);
    }

    @DisplayName("1분에 49회 조회한 IP는 예외와 함께 차단 당하지 않는다.")
    @Test
    void getNowPlayingMoviesNotRateLimitTest() {
        // given
        int maxIterCount = 49;

        for (int i = 0; i < maxIterCount - 1; i++) {
            movieQueryService.getNowPlayingMovies(null, null, "1234");
        }

        // when
        List<NowPlayMovieDto> nowPlayingMovies
                = movieQueryService.getNowPlayingMovies(null, null, "1234");

        // then
        assertThat(nowPlayingMovies).isNotEmpty();
    }

}