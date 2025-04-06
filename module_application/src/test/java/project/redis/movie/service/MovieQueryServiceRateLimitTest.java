package project.redis.movie.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;
import project.redis.CinemaApplication;

@SpringBootTest(classes = CinemaApplication.class)
class MovieQueryServiceRateLimitTest {

    @Autowired
    private MovieQueryService movieQueryService;

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

}