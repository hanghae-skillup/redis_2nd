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

    @Transactional
    @DistributedLock(key = "seat-lock:#reservationSeatsRequestDto.userId")
    public ReservationSeatsResponseDto reservationSeats(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        validReservationSeatsRequestDto(reservationSeatsRequestDto);

        User user = findUserByUserId(reservationSeatsRequestDto);
        Screening screening = findScreeningByScreeningId(reservationSeatsRequestDto);

        checkUserReservationCount(reservationSeatsRequestDto, getReservationsSize(reservationSeatsRequestDto));

        List<Reservation> reservations
                = reservationAdapter.findAllReservationByScreeningId(reservationSeatsRequestDto.getScreeningId());

        List<Long> reservationsId = createReservations(reservationSeatsRequestDto, reservations, screening, user);

        return ReservationSeatsResponseDto.of(user.getUserId(), reservationsId);
    }

    private void validReservationSeatsRequestDto(ReservationSeatsRequestDto requestDto) {
        List<String> seatRows = requestDto.getSeatRows();
        List<Integer> seatColumns = requestDto.getSeatColumns();

        if (seatRows.isEmpty() || seatColumns.isEmpty()) {
            throw new IllegalArgumentException("seatRows 또는 seatColumns가 비어 있습니다.");
        }

        if (seatRows.size() != seatColumns.size()) {
            throw new IllegalArgumentException("seatRows와 seatColumns의 개수가 같지 않습니다.");
        }

        long seatRowCount = seatRows.stream().distinct().count();
        if (seatRowCount > 1) {
            throw new IllegalArgumentException("예약하려는 좌석들의 행이 이어 붙어 있는 형태가 아닙니다.");
        }

        long seatColumnCount = seatColumns.stream().distinct().count();
        if (seatColumnCount != seatColumns.size()) {
            throw new IllegalArgumentException("예약하려는 좌석의 열이 중복됩니다.");
        }

        for (int index = 1; index < seatColumns.size(); index++) {
            if (seatColumns.get(index) != seatColumns.get(index - 1) + 1) {
                throw new IllegalArgumentException("예약하려는 좌석의 열이 연속되는 형태가 아닙니다.");
            }
        }
    }

    private User findUserByUserId(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        User user = userAdapter.findUserById(reservationSeatsRequestDto.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("존재하지 않는 유저 id 입니다.");
        }
        return user;
    }

    private Screening findScreeningByScreeningId(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        Screening screening = screeningAdapter.findScreeningById(reservationSeatsRequestDto.getScreeningId());
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

            checkReservedSeat(reservations, seatRow, seatColumn);

            Long savedReservationId = createReservation(seatRow, seatColumn, screening, user);
            reservationsId.add(savedReservationId);
        }
        return reservationsId;
    }

    private int getReservationsSize(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        return reservationSeatsRequestDto.getSeatRows().size();
    }

    private void checkReservedSeat(List<Reservation> reservations, String seatRow, Integer seatColumn) {
        boolean isAlreadyReserved = reservations.stream()
                .anyMatch(reservation -> reservation.isSeatReserved(seatRow, seatColumn));

        if (isAlreadyReserved) {
            throw new IllegalArgumentException("현재 예약된 좌석은 예약할 수 없습니다.");
        }
    }

    private Long createReservation(String seatRow, Integer seatColumn, Screening screening, User user) {
        Seat reservedSeat = Seat.of(seatRow, seatColumn);
        SeatEntity seatEntity = seatAdapter.saveSeat(reservedSeat);

        Reservation reservation = Reservation.create(reservedSeat, screening, user);
        Long savedReservationId = reservationAdapter.saveReservation(reservation, seatEntity);
        messageService.send();
        return savedReservationId;
    }

}
