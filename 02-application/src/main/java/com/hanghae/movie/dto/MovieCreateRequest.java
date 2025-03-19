package com.hanghae.movie.dto;

import com.hanghae.movie.Movie;
import com.hanghae.movie.MovieGenre;
import com.hanghae.movie.MovieGrade;

import java.time.LocalDate;

public record MovieCreateRequest(
        String title,
        MovieGrade grade,
        LocalDate releaseDate,
        String thumbnailUrl,
        int runningTime,
        MovieGenre genre
) {
    public static Movie toMovie(MovieCreateRequest request) {
        return new Movie(
                request.title(),
                request.grade(),
                request.releaseDate(),
                request.thumbnailUrl(),
                request.runningTime(),
                request.genre()
        );
    }
}
