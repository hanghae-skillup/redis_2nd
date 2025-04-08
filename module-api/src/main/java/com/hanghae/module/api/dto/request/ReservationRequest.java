package com.hanghae.module.api.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ReservationRequest {

  @NotNull(message = "사용자 ID는 필수 입력값입니다.")
  private Long userId;

  @NotNull(message = "상영 ID는 필수 입력값입니다.")
  private Long screeningId;

  @NotEmpty(message = "최소 1개 이상의 좌석을 선택해야 합니다.")
  @Size(max = 5, message = "최대 5개까지 좌석 예약이 가능합니다.")
  private List<String> seatNumbers;
}
