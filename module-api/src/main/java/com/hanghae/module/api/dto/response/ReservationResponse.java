package com.hanghae.module.api.dto.response;

import com.hanghae.module.common.enums.ReservationStatus;
import com.hanghae.module.domain.model.Reservation;
import com.hanghae.module.domain.model.ReservationSeat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class ReservationResponse {
  private Long reservationId;
  private Long userId;
  private Long screeningId;
  private List<String> seatNumbers;
  private ReservationStatus status;
  private LocalDateTime createdAt;

  public static ReservationResponse from(Reservation reservation) {
    return ReservationResponse.builder().
      reservationId(reservation.id()).
      userId(reservation.user()).
      screeningId(reservation.screening()).
      seatNumbers(reservation.seatNumbers()).
      status(reservation.status()).
      createdAt(reservation.createdAt()).
      build();
  }
}
