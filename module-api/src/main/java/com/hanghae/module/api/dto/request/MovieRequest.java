package com.hanghae.module.api.dto.request;

import com.hanghae.module.common.enums.Genre;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
  private Long theaterId;

  @Size(max = 255, message = "영화 제목은 255자를 초과할 수 없습니다.")
  private String title;

  private Genre genre;
}
