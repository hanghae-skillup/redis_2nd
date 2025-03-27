package com.hanghae.module.domain.model;

import com.hanghae.module.common.enums.Genre;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Movie(
  Long id,
  String title,
  String rating,
  LocalDate releaseDate,
  String thumbnailUrl,
  Integer runningTime,
  Genre genre) {
}
