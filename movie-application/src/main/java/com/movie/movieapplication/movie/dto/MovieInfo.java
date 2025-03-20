package com.movie.movieapplication.movie.dto;

import com.movie.movieapplication.enums.Rating;
import com.movie.movieapplication.enums.Genre;
import com.movie.movieapplication.movie.domain.Movie;

import java.time.LocalDateTime;

public class MovieInfo {

    public record Get(
            Long id, String title,
            LocalDateTime releaseDate,
            String thumbnailUrl, String runningTime,
            Rating rating, Genre genre
    ) {

        public static Get from(Movie movie) {
            return new Get(
                    movie.getId(),
                    movie.getTitle(),
                    movie.getReleasedAt(),
                    movie.getThumbnailUrl(),
                    movie.getRunningTime(),
                    movie.getRating(),
                    movie.getGenre()
            );
        }
    }

}
