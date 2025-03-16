package com.movie.moviepresentation.interfaces.movie.dto;

import com.movie.movieapplication.enums.Rating;
import com.movie.movieapplication.enums.Genre;
import com.movie.movieapplication.movie.dto.MovieInfo;

import java.time.LocalDateTime;

public class MovieDto {

    public record Response(
            Long id, String title,
            LocalDateTime releaseDate,
            String thumbnailUrl, String runningTime,
            Rating rating, Genre genre
    ) {
        public static Response of(
                Long id, String title,
                LocalDateTime releaseDate,
                String thumbnailUrl, String runningTime,
                Rating rating, Genre genre
        ) {
            return new Response(id, title, releaseDate, thumbnailUrl, runningTime, rating, genre);
        }

        public static Response from(MovieInfo.Get info) {
            return Response.of(
                    info.id(), info.title(), info.releaseDate(), info.thumbnailUrl(),
                    info.runningTime(), info.rating(), info.genre()
            );
        }
    }

}
