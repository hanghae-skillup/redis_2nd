package com.redis.application.reservation.application.service;

import com.redis.application.message.event.ReservationCompletedEvent;
import com.redis.application.reservation.application.dto.ReservationResponseDto;
import com.redis.common.util.error.BusinessException;
import com.redis.common.util.error.ErrorCode;
import com.redis.domain.reservation.entity.Reservation;
import com.redis.domain.reservation.repository.ReservationRepository;
import com.redis.domain.reservation.repository.ReservationSeatRepository;
import com.redis.application.reservation.application.convert.ApplicationReservationDtoMapper;
import com.redis.domain.screen.entity.Screen;
import com.redis.domain.screen.repository.ScreenRepository;
import com.redis.domain.seat.repository.MovieSeatRepository;
import com.redis.domain.seat.entity.MovieSeat;
import com.redis.domain.user.entity.MovieUser;
import com.redis.domain.user.repository.MovieUserRepository;
import com.redis.infra.config.RedisLock;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.redis.domain.reservation.entity.ReservationSeat;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final MovieUserRepository movieUserRepository;

    private final ScreenRepository screenRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationSeatRepository reservationSeatRepository;
    private final MovieSeatRepository movieSeatRepository;
    private final ApplicationEventPublisher eventPublisher; // 이벤트 발행
    private final RedisLock redisLock;


    @Transactional
    public ReservationResponseDto reserveMovie(Long userId, Long cinemaId, List<Long> seatIdList) {
        String lockKey = "reservation:" + cinemaId + ":" + userId;
        long leaseTime = 2000; // 2초 동안 락 유지
        long waitTime = 2000;  // 2초 동안 락 대기

        return redisLock.executeWithLock(lockKey, leaseTime, waitTime, () -> {
            MovieUser movieUser  = movieUserRepository.findById(userId).orElseThrow(() -> new BusinessException(ErrorCode.INVALID_INPUT_VALUE));
            Screen screen = screenRepository.findScreenWithCinema(cinemaId).orElseThrow(() -> new BusinessException(ErrorCode.INVALID_INPUT_VALUE));
            List<MovieSeat> seats = movieSeatRepository.findAvailableSeats(screen.getCinemaId(), seatIdList);


            if (seats.size() != seatIdList.size()) {
                throw new BusinessException(ErrorCode.INVALID_INPUT_VALUE);
            }

            validateSeatsAreConsecutive(seats);// 좌석 연속성 검증

            Reservation reservation = Reservation.builder()
                    .movieUser(movieUser)
                    .screen(screen)
                    .build();

            reservationRepository.save(reservation);

            seats.forEach(seat -> {
                seat.updateReserved();

                ReservationSeat reservationSeat = ReservationSeat.builder()
                        .reservation(reservation)
                        .seat(seat)
                        .build();

                reservationSeatRepository.save(reservationSeat);
            });

            eventPublisher.publishEvent(new ReservationCompletedEvent(
                    reservation.getReserId(),
                    movieUser.concatEmail(movieUser.getEmail01(),movieUser.getEmail02()) ,
                    screen.getCinemaNm() + "에서 상영 예정"
            ));

            return ApplicationReservationDtoMapper.toServiceReservationResponseDto(seats, screen);
        });


    }

    private void validateSeatsAreConsecutive(List<MovieSeat> seats) {
        // 좌석이 동일한 행에 있는지 확인
        String firstRow = seats.get(0).getSeatRow();
        boolean sameRow = seats.stream()
                .allMatch(seat -> seat.getSeatRow().equals(firstRow));

        if (!sameRow) {
            throw new BusinessException(ErrorCode.INVALID_INPUT_VALUE);
        }

        // 좌석이 연속된 열에 있는지 확인
        List<String> columns = seats.stream()
                .map(MovieSeat::getSeatCol)
                .sorted()
                .toList();

        for (int i = 0; i < columns.size() - 1; i++) {
            if (Integer.parseInt(columns.get(i)) + 1 != Integer.parseInt(columns.get(i + 1))) {
                throw new BusinessException(ErrorCode.INVALID_INPUT_VALUE);
            }
        }
    }
}
