package com.hanghae.module.core.dto;

import com.hanghae.module.domain.entity.Movie;
import com.hanghae.module.domain.entity.Screening;
import com.hanghae.module.domain.enums.Genre;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class MovieDTO {
  private Long movieId;
  private String title;
  private String rating;
  private LocalDate releaseDate;
  private String thumbnailUrl;
  private Integer runningTime;
  private Genre genre;
  private List<ScreeningDTO> screenings;

  // 정적 팩토리 메서드 추가
  public static MovieDTO from(Movie movie) {
    List<ScreeningDTO> screeningDTOs = movie.getScreenings().stream()
      .sorted(Comparator.comparing(Screening::getStartTime))
      .map(screening -> ScreeningDTO.builder()
        .theaterId(screening.getTheater().getId())
        .theaterName(screening.getTheater().getName())
        .startTime(screening.getStartTime())
        .endTime(screening.getEndTime())
        .screeningDate(screening.getScreeningDate())
        .build())
      .collect(Collectors.toList());

    return builder()
      .movieId(movie.getId())
      .title(movie.getTitle())
      .rating(movie.getRating())
      .releaseDate(movie.getReleaseDate())
      .thumbnailUrl(movie.getThumbnailUrl())
      .runningTime(movie.getRunningTime())
      .genre(movie.getGenre())
      .screenings(screeningDTOs)
      .build();
  }
}
