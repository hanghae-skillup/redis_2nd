package project.redis.reservation.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.redis.message.MessageService;
import project.redis.reservation.Reservation;
import project.redis.reservation.adapter.ReservationAdapter;
import project.redis.reservation.dto.ReservationSeatsRequestDto;
import project.redis.reservation.dto.ReservationSeatsResponseDto;
import project.redis.screening.Screening;
import project.redis.screening.adapter.ScreeningAdapter;
import project.redis.seat.Seat;
import project.redis.user.User;
import project.redis.user.adapter.UserAdapter;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private static final int MAX_USER_RESERVATION_COUNT = 5;

    private final UserAdapter userAdapter;
    private final ScreeningAdapter screeningAdapter;
    private final ReservationAdapter reservationAdapter;
    private final MessageService messageService;

    // TODO : 리팩토링 필요 (메서드 분리 등)
    public ReservationSeatsResponseDto reservationSeats(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        validReservationSeatsRequestDto(reservationSeatsRequestDto);

        User user = userAdapter.findUserById(reservationSeatsRequestDto.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("존재하지 않는 유저 id 입니다.");
        }

        Screening screening = screeningAdapter.findScreeningById(reservationSeatsRequestDto.getScreeningId());
        if (screening == null) {
            throw new IllegalArgumentException("존재하지 않는 상영 id 입니다.");
        }

        List<String> seatRows = reservationSeatsRequestDto.getSeatRows();
        List<Integer> seatColumns = reservationSeatsRequestDto.getSeatColumns();

        int reservationCount = seatRows.size();

        // TODO : user의 reservation 개수에 대한 검증 필요
        List<Reservation> userReservations
                = reservationAdapter.findAllReservationByUserId(reservationSeatsRequestDto.getUserId());
        if (userReservations.size() + reservationCount > MAX_USER_RESERVATION_COUNT) {
            throw new IllegalArgumentException("유저당 예약은 " + MAX_USER_RESERVATION_COUNT + " 개까지 가능합니다.");
        }

        List<Reservation> reservations
                = reservationAdapter.findAllReservationByScreeningId(reservationSeatsRequestDto.getScreeningId());

        List<Long> reservationsId = new ArrayList<>();

        for (int index = 0; index < reservationCount; index++) {
            String seatRow = seatRows.get(index);
            Integer seatColumn = seatColumns.get(index);
            boolean isAlreadyReserved = reservations.stream()
                    .anyMatch(reservation -> reservation.isSeatReserved(seatRow, seatColumn));

            if (isAlreadyReserved) {
                throw new IllegalArgumentException("현재 예약된 좌석은 예약할 수 없습니다.");
            }

            Seat reservedSeat = Seat.of(seatRow, seatColumn);
            Reservation reservation = Reservation.create(reservedSeat, screening, user);
            Long savedReservationId = reservationAdapter.saveReservation(reservation);
            messageService.send();
            reservationsId.add(savedReservationId);
        }

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

    }
}
