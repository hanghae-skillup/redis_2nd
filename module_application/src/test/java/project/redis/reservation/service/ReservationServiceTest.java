package project.redis.reservation.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import project.redis.CinemaApplication;
import project.redis.message.MessageLogService;
import project.redis.message.MessageService;
import project.redis.reservation.adapter.ReservationAdapter;
import project.redis.reservation.adapter.ReservationAdapterImpl;
import project.redis.reservation.dto.ReservationSeatsRequestDto;
import project.redis.reservation.dto.ReservationSeatsResponseDto;
import project.redis.screening.adapter.ScreeningAdapter;
import project.redis.screening.adapter.ScreeningAdapterImpl;
import project.redis.seat.adapter.SeatAdapter;
import project.redis.seat.adapter.SeatAdapterImpl;
import project.redis.user.adapter.UserAdapter;
import project.redis.user.adapter.UserAdapterImpl;

@SpringBootTest(classes = CinemaApplication.class)
@Import({ReservationService.class,
        UserAdapterImpl.class,
        ScreeningAdapterImpl.class,
        ReservationAdapterImpl.class,
        SeatAdapterImpl.class,
        MessageLogService.class})
class ReservationServiceTest {
    @Autowired
    ReservationService reservationService;
    @Autowired
    private UserAdapter userAdapter;
    @Autowired
    private ScreeningAdapter screeningAdapter;
    @Autowired
    private ReservationAdapter reservationAdapter;
    @Autowired
    private SeatAdapter seatAdapter;
    @Autowired
    private MessageService messageService;

    @DisplayName("같은 상영의 같은 좌석에 대해 동시에 예약이 될 수 없어야 한다.")
    @Test
    void reservationSeatsTest() {

        Long userId = 1L;

        ReservationSeatsRequestDto requestDto1
                = ReservationSeatsRequestDto.of(userId, 10L, List.of("A"), List.of(1));

        ReservationSeatsRequestDto requestDto2
                = ReservationSeatsRequestDto.of(2L, 10L, List.of("A"), List.of(1));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch;
        latch = new CountDownLatch(1);

        Runnable task1 = () -> {
            try {
                latch.await(); // 동시에 시작되도록 대기
                ReservationSeatsResponseDto reservationSeatsResponseDto
                        = reservationService.reservationSeats(requestDto1);
                Long userIdResult = reservationSeatsResponseDto.getUserId();
                List<Long> reservationsIdResult = reservationSeatsResponseDto.getReservationsId();

                assertThat(userIdResult).isEqualTo(userId);
                assertThat(reservationsIdResult.size()).isEqualTo(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                latch.await(); // 동시에 시작되도록 대기
                reservationService.reservationSeats(requestDto2);
            } catch (Exception e) {
                System.out.println("예외 발생");
                assertThatThrownBy(() -> {
                    throw e;
                })
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("현재 예약된 좌석은 예약할 수 없습니다.");
            }
        };

        executor.submit(task1);
        executor.submit(task2);

        latch.countDown(); // 두 스레드 동시에 시작
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);  // 실행 완료될 때까지 대기
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}