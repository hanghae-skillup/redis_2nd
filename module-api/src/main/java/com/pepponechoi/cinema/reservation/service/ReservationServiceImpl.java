package com.pepponechoi.cinema.reservation.service;

import com.pepponechoi.cinema.event.EventPublisher;
import com.pepponechoi.cinema.event.ReservationCompletedEvent;
import com.pepponechoi.cinema.exception.enums.BadRequestErrorCode;
import com.pepponechoi.cinema.exception.enums.ConfliectErrorCode;
import com.pepponechoi.cinema.exception.enums.NotFoundErrorCode;
import com.pepponechoi.cinema.exception.exception.BadRequestException;
import com.pepponechoi.cinema.exception.exception.ConflictException;
import com.pepponechoi.cinema.exception.exception.NotFoundException;
import com.pepponechoi.cinema.reservation.dto.request.create.CreateReservationRequest;
import com.pepponechoi.cinema.reservation.dto.response.ReservationResponse;
import com.pepponechoi.cinema.reservation.entity.Reservation;
import com.pepponechoi.cinema.reservation.repository.ReservationRepository;
import com.pepponechoi.cinema.schedule.entity.Schedule;
import com.pepponechoi.cinema.schedule.repository.ScheduleRepository;
import com.pepponechoi.cinema.seat.entity.Seat;
import com.pepponechoi.cinema.seat.repository.SeatRepository;
import com.pepponechoi.cinema.user.entity.User;
import com.pepponechoi.cinema.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final SeatRepository seatRepository;
    private final ScheduleRepository scheduleRepository;
    private final EventPublisher eventPublisher;
    private final RedissonClient redisson;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ReservationResponse create(CreateReservationRequest request) {
        User user = userRepository.findById(request.userId()).orElseThrow(
                () -> {
                    NotFoundException exception = new NotFoundException();
                    exception.setErrorCode(NotFoundErrorCode.RESOURCE_NOT_FOUND);
                    exception.setDetail("해당하는 유저를 찾을 수 없습니다.");
                    return exception;
                }
        );

        Schedule schedule = scheduleRepository.findById(request.scheduleId()).orElseThrow(
                () -> {
                    NotFoundException exception = new NotFoundException();
                    exception.setErrorCode(NotFoundErrorCode.RESOURCE_NOT_FOUND);
                    exception.setDetail("해당하는 상영 스케쥴을 찾을 수 없습니다.");
                    return exception;
                }
        );

        Integer userReservedSeats =
            seatRepository.countByReservation_UserIdAndReservation_ScheduleId(user.getId(),
            schedule.getId());

        System.out.println("userReservedSeats = " + userReservedSeats);

        if (userReservedSeats + request.seats().size() > 5) {
            ConflictException exception = new ConflictException();
            exception.setErrorCode(ConfliectErrorCode.CONFLICT);
            exception.setDetail("각 유저의 좌석은 스케쥴 당 5개를 넘지 못합니다.");
            throw exception;
        }

        List<Seat> seats = request.seats().stream().map(seat -> seatRepository.findByScreenIdAndRowNoAndColumnNoAndReservationIsNull(schedule.getScreen().getId(), seat.rowNo(), seat.columnNo()).orElseThrow(
                () -> {
                    ConflictException exception = new ConflictException();
                    exception.setErrorCode(ConfliectErrorCode.CONFLICT);
                    exception.setDetail("해당하는 좌석이 없거나 이미 예약되어 있는 좌석입니다.");
                    throw exception;
                }
        )).toList();

        // 1. 각 Seat의 최대 갯수가 5개이하인지
        if (seats.isEmpty() || seats.size() > 5) {
            BadRequestException exception = new BadRequestException();
            exception.setErrorCode(BadRequestErrorCode.VALIDATION_FAILED);
            exception.setDetail("좌석은 0석 이상 5석 이하로 선택 하여야 합니다.");
            throw exception;
        }

        // Seat의 크기가 2이상이면 Valid
        if (seats.size() >= 2) {
            Map<Character, Set<Integer>> setMap = new HashMap<>();

            seats.forEach(seat -> {
                setMap.computeIfAbsent(seat.getRowNo(), k -> new HashSet<>());
                if (setMap.get(seat.getRowNo()).contains(seat.getColumnNo())) {
                    ConflictException exception = new ConflictException();
                    exception.setErrorCode(ConfliectErrorCode.CONFLICT);
                    exception.setDetail("좌석은 중복될 수 없습니다.");
                    throw exception;
                }
                setMap.get(seat.getRowNo()).add(seat.getColumnNo());
            });

            if (setMap.size() >= 2) {
                BadRequestException exception = new BadRequestException();
                exception.setErrorCode(BadRequestErrorCode.VALIDATION_FAILED);
                exception.setDetail("2개 이상의 좌석은 같은 행에 있어야 합니다.");
                throw exception;
            }

            setMap.forEach((rowNo, columnNoSet) -> {
                List<Integer> seatRowNos = columnNoSet.stream().sorted().toList();

                if (!IntStream.range(1, seatRowNos.size())
                    .allMatch(index -> seatRowNos.get(index) - seatRowNos.get(index - 1) == 1)
                ) {
                    BadRequestException exception = new BadRequestException();
                    exception.setErrorCode(BadRequestErrorCode.VALIDATION_FAILED);
                    exception.setDetail("좌석은 이어져 있어야 합니다.");
                    throw exception;
                }
            });
        }

        Reservation reservation = Reservation.of(user, seats, schedule, String.valueOf(user.getId()));

        List<RLock> locks = new ArrayList<>();

        try {
            for (var seat : request.seats()) {
                String seatLockKey =
                    "seatLock:" + request.scheduleId() + ":" + seat.rowNo() + ":" + seat.columnNo();
                RLock seatLock = redisson.getLock(seatLockKey);

                if (!seatLock.tryLock(2, 1, TimeUnit.SECONDS)) {
                    ConflictException exception = new ConflictException();
                    exception.setDetail("좌석 예약 중 충돌이 발생했습니다. 다시 시도해 주세요.");
                    throw exception;
                }
                locks.add(seatLock); // Save acquired locks
            }

            reservationRepository.save(reservation);

            seats.forEach(seat -> {
                seat.setReservation(reservation);
            });

            eventPublisher.publish(new ReservationCompletedEvent(
                reservation.getId(),
                reservation.getUser().getId()
            ));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            ConflictException exception = new ConflictException();
            exception.setDetail("록 획득 중 인터럽트 되었습니다.");
        }

        return ReservationResponse.of(reservation);
    }
}
