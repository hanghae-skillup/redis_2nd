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

    private final UserAdapter userAdapter;
    private final ScreeningAdapter screeningAdapter;
    private final ReservationAdapter reservationAdapter;
    private final MessageService messageService;

    public ReservationSeatsResponseDto reservationSeats(ReservationSeatsRequestDto reservationSeatsRequestDto) {

        User user = userAdapter.findUserById(reservationSeatsRequestDto.getUserId());
        // TODO : user null일 때 예외 처리 (잘못된 userId)
        Screening screening = screeningAdapter.findScreeningById(reservationSeatsRequestDto.getScreeningId());
        // TODO : screening null일 때 예외 처리 (잘못된 screeningId)

        List<String> seatRows = reservationSeatsRequestDto.getSeatRows();
        List<Integer> seatColumns = reservationSeatsRequestDto.getSeatColumns();

        // 상영관에 해당하는 reservation들 가져와서 Seat들 확인하기
        List<Reservation> reservations
                = reservationAdapter.findAllReservationByScreeningId(reservationSeatsRequestDto.getScreeningId());

        List<Long> reservationsId = new ArrayList<>();

        for (int index = 0; index < seatRows.size(); index++) {
            String seatRow = seatRows.get(index);
            Integer seatColumn = seatColumns.get(index);
            boolean isAlreadyReserved = reservations.stream()
                    .anyMatch(reservation -> reservation.isSeatReserved(seatRow, seatColumn));

            if (isAlreadyReserved) {
                // TODO : 상영관의 모든 예약들의 seat 중에 예약하려는 seat이 존재하니 예외 처리 (예약된 좌석 예약 시도)
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
