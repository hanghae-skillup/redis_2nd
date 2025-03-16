package com.app.movie.mapper;

import com.app.movie.entity.GenreEntity;
import com.app.movie.entity.MovieEntity;
import com.app.movie.model.Genre;
import com.app.movie.model.Movie;

import java.time.LocalDateTime;

public class MovieMapper {

    // 변환 메서드: Entity -> Domain
    public static Movie convertToDomain(MovieEntity entity) {
        GenreEntity genreEntity = entity.getGenre();
        Genre genre = new Genre(genreEntity.getId(), genreEntity.getName());
        return new Movie(
                entity.getId(),
                entity.getTitle(),
                entity.getThumbnailURL(),
                entity.getReleaseDate(),
                entity.getDuration(),
                genre,
                entity.getRating()
        );
    }

    // 변환 메서드: Domain -> Entity
    public static MovieEntity convertToEntity(Movie movie) {
        Genre genre = movie.getGenre();
        LocalDateTime today = LocalDateTime.now();
        String adminName = "admin";
        GenreEntity genreEntity = new GenreEntity(
                genre.getId(),
                genre.getName(),
                adminName,
                today,
                adminName,
                today
        );
        MovieEntity movieEntity = new MovieEntity(
                movie.getId(),
                movie.getTitle(),
                movie.getThumbnailURL(),
                movie.getReleaseDate(),
                movie.getDuration(),
                genreEntity,
                movie.getRating(),
                adminName,
                today,
                adminName,
                today
        );
        return movieEntity;
    }

}
