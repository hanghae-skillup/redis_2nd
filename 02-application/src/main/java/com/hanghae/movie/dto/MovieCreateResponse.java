package com.hanghae.movie.dto;

import com.hanghae.common.vo.PositiveNumber;
import com.hanghae.movie.Movie;
import com.hanghae.movie.MovieGenre;
import com.hanghae.movie.MovieGrade;
import com.hanghae.movie.UrlString;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MovieCreateResponse(
        Long id,
        String title,
        MovieGrade grade,
        LocalDate releaseDate,
        UrlString thumbnailUrl,
        PositiveNumber runningTime,
        MovieGenre genre,
        LocalDateTime createdDate,
        String createdBy
) {
    public static MovieCreateResponse from(Movie movie) {
        return new MovieCreateResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getGrade(),
                movie.getReleaseDate(),
                movie.getThumbnailUrl(),
                movie.getRunningTimeMin(),
                movie.getGenre(),
                movie.getCreatedDate(),
                movie.getCreatedBy()
        );
    }
}
