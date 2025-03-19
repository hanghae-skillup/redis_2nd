package com.hanghae.module.core.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class ScreeningDTO {
  private Long theaterId;
  private String theaterName;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private LocalDate screeningDate;
}
