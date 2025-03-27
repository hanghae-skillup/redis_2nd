package com.hanghae.module.common.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ScreeningDTO {
  private Long theaterId;
  private String theaterName;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

  // 모든 필드를 포함하는 생성자
  public ScreeningDTO(Long theaterId, String theaterName,
                      LocalDateTime startTime, LocalDateTime endTime) {
    this.theaterId = theaterId;
    this.theaterName = theaterName;
    this.startTime = startTime;
    this.endTime = endTime;
  }
}
