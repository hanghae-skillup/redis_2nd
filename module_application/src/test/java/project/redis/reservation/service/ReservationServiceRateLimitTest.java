package project.redis.reservation.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;
import project.redis.TestApplication;
import project.redis.ratelimiter.reserveratelimiter.ReserveRateLimiter;
import project.redis.reservation.dto.ReservationSeatsRequestDto;

@ActiveProfiles("test")
@SpringBootTest(classes = TestApplication.class)
class ReservationServiceRateLimitTest {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private @Qualifier("RedisReserveRateLimiter") ReserveRateLimiter reserveRateLimiter;

    @BeforeEach
    void clearBefore() {
        reserveRateLimiter.clear();
    }

    @AfterEach
    void clearAfter() {
        reserveRateLimiter.clear();
    }

    @DisplayName("한 유저가 한 상영에 대해 예약 후 5분 이내에 또 예약 시 예외와 함께 차단 당한다.")
    @Test
    void reserveSeatsTest() {
        // given
        Long userId = 1L;
        Long screeningId = 1L;

        ReservationSeatsRequestDto firstReservationSeatsRequestDto
                = ReservationSeatsRequestDto.of(userId, screeningId, List.of("A"), List.of(1));

        ReservationSeatsRequestDto secondReservationSeatsRequestDto
                = ReservationSeatsRequestDto.of(userId, screeningId, List.of("A"), List.of(2));

        reservationService.reserveSeats(firstReservationSeatsRequestDto);

        // when then
        Assertions.assertThatThrownBy(() -> reservationService.reserveSeats(secondReservationSeatsRequestDto))
                .isInstanceOf(ResponseStatusException.class);
    }

}