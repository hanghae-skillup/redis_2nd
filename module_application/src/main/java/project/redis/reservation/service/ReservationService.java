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

    public ReservationSeatsResponseDto reservationSeats(ReservationSeatsRequestDto reservationSeatsRequestDto)
            throws InterruptedException {
        /* TODO: dto의 입력 값 검증
            1. seatRows와 seatColumns의 개수가 같은지
            2. seatRows가 여러 개라면 같은 문자만 들어 있는지
            3. seatColumns가 여러 개라면 같은 숫자는 없는지
         */

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
}
