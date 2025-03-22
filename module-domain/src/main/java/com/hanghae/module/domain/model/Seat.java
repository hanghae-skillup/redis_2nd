package com.hanghae.module.domain.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record Seat(
  Long id,
  Long screening,
  String seatNumber,
  BigDecimal amount
) {
}
