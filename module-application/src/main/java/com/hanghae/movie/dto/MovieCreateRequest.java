package com.hanghae.movie.dto;

import com.hanghae.movie.Movie;
import com.hanghae.movie.MovieGenre;
import com.hanghae.movie.MovieGrade;
import com.hanghae.movie.MovieStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record MovieCreateRequest(

        @NotBlank String title,
        @NotNull MovieGrade grade,
        @NotNull MovieStatus status,
        @NotNull LocalDate releaseDate,
        @NotBlank String thumbnailUrl,
        @Positive int runningTime,
        @NotNull MovieGenre genre
) {
    public static Movie toMovie(MovieCreateRequest request) {
        return new Movie(
                request.title(),
                request.grade(),
                request.status(),
                request.releaseDate(),
                request.thumbnailUrl(),
                request.runningTime(),
                request.genre()
        );
    }
}
