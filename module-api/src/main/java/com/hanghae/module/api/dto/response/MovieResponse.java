package com.hanghae.module.api.dto.response;

import com.hanghae.module.core.dto.MovieDTO;
import com.hanghae.module.core.dto.ScreeningDTO;
import com.hanghae.module.domain.enums.Genre;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Getter
@Builder
public class MovieResponse {
  private final Long movieId;
  private final String title;
  private final Genre genre;
  private final String rating;
  private final LocalDate releaseDate;
  private final String thumbnailUrl;
  private final Integer runningTime;
  private final List<ScreeningResponse> screenings;

  // 정적 팩토리 메서드 추가
  public static MovieResponse from(MovieDTO dto) {
    return builder()
      .movieId(dto.getMovieId())
      .title(dto.getTitle())
      .genre(dto.getGenre())
      .rating(dto.getRating())
      .releaseDate(dto.getReleaseDate())
      .thumbnailUrl(dto.getThumbnailUrl())
      .runningTime(dto.getRunningTime())
      .screenings(
        dto.getScreenings().stream()
          .map(ScreeningResponse::from)
          .sorted(Comparator.comparing(ScreeningResponse::getStartTime))
          .toList()
      )
      .build();
  }

  @Getter
  @Builder
  public static class ScreeningResponse {
    private final Long theaterId;
    private final String theaterName;
    private final LocalDateTime startTime;

    // 스크리닝 DTO를 위한 정적 팩토리 메서드
    public static ScreeningResponse from(ScreeningDTO screeningDto) {
      return builder()
        .theaterId(screeningDto.getTheaterId())
        .theaterName(screeningDto.getTheaterName())
        .startTime(screeningDto.getStartTime())
        .build();
    }
  }
}
