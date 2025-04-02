package com.redis.application;

import com.redis.application.reservation.application.dto.ReservationResponseDto;
import com.redis.application.reservation.application.service.ReservationService;
import com.redis.common.util.error.BusinessException;
import com.redis.common.util.error.ErrorCode;
import com.redis.domain.reservation.entity.Reservation;
import com.redis.domain.reservation.entity.ReservationSeat;
import com.redis.domain.reservation.repository.ReservationRepository;
import com.redis.domain.reservation.repository.ReservationSeatRepository;
import com.redis.domain.screen.entity.Screen;
import com.redis.domain.screen.repository.ScreenRepository;
import com.redis.domain.seat.entity.MovieSeat;
import com.redis.domain.seat.repository.MovieSeatRepository;
import com.redis.domain.user.entity.MovieUser;
import com.redis.domain.user.repository.MovieUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private MovieUserRepository movieUserRepository;

    @Mock
    private ScreenRepository screeningRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private ReservationSeatRepository reservationSeatRepository;

    @Mock
    private MovieSeatRepository movieSeatRepository;

    private MovieUser movieUser;
    private Screen screen;
    private List<MovieSeat> seats;

    @BeforeEach
    void setUp() {
        // 테스트용 데이터 초기화
        movieUser = MovieUser.builder().userId(1L).build();

        screen = Screen.builder().cinemaId(1L).movieStartTime(LocalDateTime.now()).movieEndTime(LocalDateTime.now().plusHours(2)).build();

        seats = Arrays.asList(
                MovieSeat.builder().seatId(1L).seatRow("B").seatCol("1").isReserved(false).build(),
                MovieSeat.builder().seatId(2L).seatRow("B").seatCol("2").isReserved(false).build(),
                MovieSeat.builder().seatId(3L).seatRow("B").seatCol("3").isReserved(false).build()
        );
    }

    @Test
    @DisplayName("성공 시나리오")
    void reserveMovie_success() {
        // given
        Mockito.when(movieUserRepository.findById(1L)).thenReturn(Optional.of(movieUser));
        Mockito.when(screeningRepository.findScreenWithCinema(1L)).thenReturn(Optional.of(screen));
        Mockito.when(movieSeatRepository.findAvailableSeats(1L, Arrays.asList(1L, 2L, 3L))).thenReturn(seats);

        //when
        ReservationResponseDto response = reservationService.reserveMovie(1L, 1L, Arrays.asList(1L, 2L, 3L));

        //then
        assertNotNull(response);
        verify(reservationRepository, times(1)).save(any(Reservation.class));
        verify(reservationSeatRepository, times(seats.size())).save(any(ReservationSeat.class));

    }

    @Test
    @DisplayName("좌석 수 매칭")
    void reserveMovie_seatMismatch() {
        // given
        Mockito.when(movieUserRepository.findById(1L)).thenReturn(Optional.of(movieUser));
        Mockito.when(screeningRepository.findScreenWithCinema(1L)).thenReturn(Optional.of(screen));
        Mockito.when(movieSeatRepository.findAvailableSeats(1L, Arrays.asList(1L, 2L, 3L))).thenReturn(Arrays.asList(seats.get(0), seats.get(1)));


        //when
        BusinessException exception = assertThrows(BusinessException.class,
                () -> reservationService.reserveMovie(1L, 1L, Arrays.asList(1L, 2L, 3L)));
        Assertions.assertEquals(ErrorCode.INVALID_INPUT_VALUE, exception.getErrorCode());
    }

    @Test
    @DisplayName("좌석 연속성 테스트")
    void reserveMovie_seatsNotConsecutive() {
        // given
        when(movieUserRepository.findById(1L)).thenReturn(Optional.of(movieUser));
        when(screeningRepository.findScreenWithCinema(1L)).thenReturn(Optional.of(screen));
        List<MovieSeat> nonConsecutiveSeats = Arrays.asList(
                MovieSeat.builder().seatId(1L).seatRow("A").seatCol("1").isReserved(false).build(),
                MovieSeat.builder().seatId(2L).seatRow("A").seatCol("3").isReserved(false).build() // 연속되지 않음
        );
        when(movieSeatRepository.findAvailableSeats(1L, List.of(1L, 2L))).thenReturn(nonConsecutiveSeats);

        // when & then
        BusinessException exception = assertThrows(BusinessException.class,
                () -> reservationService.reserveMovie(1L, 1L, List.of(1L, 2L)));
        Assertions.assertEquals(ErrorCode.INVALID_INPUT_VALUE, exception.getErrorCode());
    }
}
