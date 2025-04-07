package project.redis.reservation.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import project.redis.TestApplication;
import project.redis.reservation.Reservation;
import project.redis.reservation.adapter.ReservationAdapter;
import project.redis.reservation.dto.ReservationSeatsRequestDto;
import project.redis.reservation.dto.ReservationSeatsResponseDto;

@ActiveProfiles("test")
@SpringBootTest(classes = TestApplication.class)
class ReservationServiceTest {
    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationAdapter reservationAdapter;

    @DisplayName("같은 상영의 같은 좌석에 대해 동시에 예약이 될 수 없어야 한다.")
        // @Test
    void reserveSeatsTest() {

        Long userId = 1L;
        Long screeningId = 10L;

        ReservationSeatsRequestDto requestDto1
                = ReservationSeatsRequestDto.of(userId, screeningId, List.of("A"), List.of(1));

        ReservationSeatsRequestDto requestDto2
                = ReservationSeatsRequestDto.of(2L, screeningId, List.of("A"), List.of(1));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch;
        latch = new CountDownLatch(1);

        Runnable task1 = () -> {
            try {
                latch.await(); // 동시에 시작되도록 대기
                ReservationSeatsResponseDto reservationSeatsResponseDto
                        = reservationService.reserveSeats(requestDto1);
                // Long userIdResult = reservationSeatsResponseDto.getUserId();
                // List<Long> reservationsIdResult = reservationSeatsResponseDto.getReservationsId();

                // assertThat(userIdResult).isEqualTo(userId);
                // assertThat(reservationsIdResult.size()).isEqualTo(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                latch.await(); // 동시에 시작되도록 대기
                ReservationSeatsResponseDto reservationSeatsResponseDto
                        = reservationService.reserveSeats(requestDto2);
                // assertThat(reservationSeatsResponseDto.getReservationsId().size()).isEqualTo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        executor.submit(task1);
        executor.submit(task2);

        latch.countDown(); // 두 스레드 동시에 시작
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);  // 실행 완료될 때까지 대기
            List<Reservation> reservations
                    = reservationAdapter.findAllReservationByScreeningId(screeningId);
            assertThat(reservations.size()).isEqualTo(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}