package com.hanghae.module.core.facade;

import com.hanghae.module.common.enums.ReservationStatus;
import com.hanghae.module.domain.model.Reservation;
import com.hanghae.module.domain.model.ReservationSeat;
import com.hanghae.module.domain.model.Screening;
import com.hanghae.module.domain.model.Seat;
import com.hanghae.module.domain.service.ReservationSeatService;
import com.hanghae.module.domain.service.ReservationService;
import com.hanghae.module.domain.service.ScreeningService;
import com.hanghae.module.domain.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class ReservationFacade {

  private final ScreeningService screeningService;
  private final ReservationSeatService reservationSeatService;
  private final ReservationService reservationService;
  private final SeatService seatService;

  public Reservation reserve(Long userId, Long screeningId, List<String> seatNumbers) {
    // 1. 상영 정보 조회
    Screening screening = screeningService.findById(screeningId);
    // 2. 좌석 조회
    List<Seat> seats = seatService.getSeats(screeningId, seatNumbers);
    // 2. 좌석 검증
    seatService.validateSeats(seats, screening);
    // 3. 예약 생성 및 저장
    Reservation reservation = reservationService.saveReservation(Reservation.create(userId, screeningId, seatNumbers));
    // 4. 좌석 예약
    seatService.assignSeats(seats);
    // 5. 예약 좌석 정보 저장
    for (Seat seat : seats) {
      reservationSeatService.saveReservationSeat(ReservationSeat.create(reservation.id(), seat.id()));
    }

    //5. 예약 상태 업데이트
    return reservationService.saveReservation(reservation.updateStatus(ReservationStatus.CONFIRMED));
  }
}
