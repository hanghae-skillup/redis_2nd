package com.hanghae.module.domain.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Screening(
  Long id,
  Long movie,
  Long theater,
  LocalDateTime startTime,
  LocalDateTime endTime
) {
}
