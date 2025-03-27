package com.hanghae.module.domain.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record ReservationSeat(
  Long id,
  Long reservation,
  Long seat,
  BigDecimal amount,
  LocalDateTime reservedAt
) {
}
