package project.redis.movie.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.redis.CinemaApplication;

@SpringBootTest(classes = CinemaApplication.class)
class MovieQueryServiceRateLimitTest {

    @Autowired
    private MovieQueryService movieQueryService;

    @DisplayName("1분에 50회 이상 조회한 IP는 예외와 함께 차단 당한다.")
    @Test
    void getNowPlayingMoviesRateLimitTest() {
        // given

        // when

        // then
    }

}