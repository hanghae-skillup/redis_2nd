package com.hanghae.module.domain.model;

import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record ReservationSeat(
  Long id,
  Long reservation,
  Long seat,
  LocalDateTime reservedAt
) {

  public static ReservationSeat create(Long reservationId, Long seatId) {
    return ReservationSeat.builder()
      .reservation(reservationId)
      .seat(seatId)
      .reservedAt(LocalDateTime.now())
      .build();
  }
}
