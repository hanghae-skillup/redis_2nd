package com.hanghae.module.domain.model;

import com.hanghae.module.common.enums.ReservationStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Reservation(
  Long id,
  Long user,
  Long screening,
  ReservationStatus status,
  LocalDateTime createdAt
) {
}
