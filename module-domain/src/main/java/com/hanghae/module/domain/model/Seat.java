package com.hanghae.module.domain.model;

import com.hanghae.module.common.enums.SeatStatus;
import lombok.Builder;
import java.math.BigDecimal;

@Builder
public record Seat(
  Long id,
  Long screening,
  String seatNumber,
  SeatStatus status,
  BigDecimal price
) {
  public boolean isReserved() {
    if (status == null) {
      return false;
    }
    return status == SeatStatus.RESERVED;
  }

  public Seat assign() {
    if (isReserved()) {
      throw new IllegalStateException("Seat is already reserved");
    }
    return new Seat(id, screening, seatNumber, SeatStatus.RESERVED, price);
  }
}
