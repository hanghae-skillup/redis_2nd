package com.hanghae.module.common.dto;

import com.hanghae.module.common.enums.Genre;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

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

  public MovieDTO(Long movieId, String title, String rating, LocalDate releaseDate,
                  String thumbnailUrl, Integer runningTime, Genre genre,
                  List<ScreeningDTO> screenings) {
    this.movieId = movieId;
    this.title = title;
    this.rating = rating;
    this.releaseDate = releaseDate;
    this.thumbnailUrl = thumbnailUrl;
    this.runningTime = runningTime;
    this.genre = genre;
    this.screenings = screenings;
  }
}
