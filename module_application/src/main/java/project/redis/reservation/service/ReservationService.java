package project.redis.reservation.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.redis.lock.DistributedLock;
import project.redis.message.MessageService;
import project.redis.reservation.Reservation;
import project.redis.reservation.adapter.ReservationAdapter;
import project.redis.reservation.dto.ReservationSeatsRequestDto;
import project.redis.reservation.dto.ReservationSeatsResponseDto;
import project.redis.reservation.validator.ReservationValidator;
import project.redis.screening.Screening;
import project.redis.screening.adapter.ScreeningAdapter;
import project.redis.seat.Seat;
import project.redis.seat.adapter.SeatAdapter;
import project.redis.seat.entity.SeatEntity;
import project.redis.user.User;
import project.redis.user.adapter.UserAdapter;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {

    private static final int MAX_USER_RESERVATION_COUNT = 5;

    private final UserAdapter userAdapter;
    private final ScreeningAdapter screeningAdapter;
    private final ReservationAdapter reservationAdapter;
    private final SeatAdapter seatAdapter;
    private final MessageService messageService;
    private final ReservationValidator reservationValidator;

    @Transactional
    @DistributedLock(key = "seat-lock:#reservationSeatsRequestDto.userId")
    public ReservationSeatsResponseDto reserveSeats(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        reservationValidator.valid(reservationSeatsRequestDto);

        User user = findUserByUserId(reservationSeatsRequestDto);
        Screening screening = findScreeningByScreeningId(reservationSeatsRequestDto);

        checkUserReservationCount(reservationSeatsRequestDto, getReservationsSize(reservationSeatsRequestDto));

        List<Reservation> reservations
                = reservationAdapter.findAllReservationByScreeningId(reservationSeatsRequestDto.getScreeningId());

        List<Long> reservationsId = createReservations(reservationSeatsRequestDto, reservations, screening, user);

        return ReservationSeatsResponseDto.of(user.getUserId(), reservationsId);
    }

    private User findUserByUserId(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        User user = userAdapter.find(reservationSeatsRequestDto.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("존재하지 않는 유저 id 입니다.");
        }
        return user;
    }

    private Screening findScreeningByScreeningId(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        Screening screening = screeningAdapter.findScreening(reservationSeatsRequestDto.getScreeningId());
        if (screening == null) {
            throw new IllegalArgumentException("존재하지 않는 상영 id 입니다.");
        }
        return screening;
    }

    private void checkUserReservationCount(ReservationSeatsRequestDto reservationSeatsRequestDto,
                                           int reservationCount) {
        List<Reservation> userReservations
                = reservationAdapter.findAllReservationByUserId(reservationSeatsRequestDto.getUserId());
        if (userReservations.size() + reservationCount > MAX_USER_RESERVATION_COUNT) {
            throw new IllegalArgumentException("유저당 예약은 " + MAX_USER_RESERVATION_COUNT + " 개까지 가능합니다.");
        }
    }

    private List<Long> createReservations(ReservationSeatsRequestDto reservationSeatsRequestDto,
                                          List<Reservation> reservations, Screening screening, User user) {
        int reservationCount = getReservationsSize(reservationSeatsRequestDto);

        List<Long> reservationsId = new ArrayList<>();

        for (int index = 0; index < reservationCount; index++) {
            String seatRow = reservationSeatsRequestDto.getSeatRows().get(index);
            Integer seatColumn = reservationSeatsRequestDto.getSeatColumns().get(index);

            containsSameSeat(reservations, seatRow, seatColumn);

            Long savedReservationId = createReservation(seatRow, seatColumn, screening, user);
            reservationsId.add(savedReservationId);
        }
        return reservationsId;
    }

    private int getReservationsSize(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        return reservationSeatsRequestDto.getSeatRows().size();
    }

    private void containsSameSeat(List<Reservation> reservations, String seatRow, Integer seatColumn) {
        boolean hasSameSeat = reservations.stream()
                .anyMatch(reservation -> reservation.checkSameSeat(seatRow, seatColumn));

        if (hasSameSeat) {
            throw new IllegalArgumentException("현재 예약된 좌석은 예약할 수 없습니다.");
        }
    }

    private Long createReservation(String seatRow, Integer seatColumn, Screening screening, User user) {
        Seat reservedSeat = Seat.of(seatRow, seatColumn);
        SeatEntity seatEntity = seatAdapter.save(reservedSeat);

        Reservation reservation = Reservation.create(reservedSeat, screening, user);
        Long savedReservationId = reservationAdapter.saveReservation(reservation, seatEntity);
        messageService.send();
        return savedReservationId;
    }

}
