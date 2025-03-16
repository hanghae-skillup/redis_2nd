package com.app.movie.mapper;

import com.app.movie.entity.GenreEntity;
import com.app.movie.entity.MovieEntity;
import com.app.movie.entity.TheaterEntity;
import com.app.movie.model.Genre;
import com.app.movie.model.Movie;
import com.app.movie.model.Theater;

import java.time.LocalDateTime;

public class TheaterMapper {

    // 변환 메서드: Entity -> Domain
    public static Theater convertToDomain(TheaterEntity entity) {
        return new Theater(
                entity.getId(),
                entity.getName()
        );
    }

    // 변환 메서드: Domain -> Entity
    public static TheaterEntity convertToEntity(Theater theater) {
        String name = "admin";
        LocalDateTime today = LocalDateTime.now();
        return new TheaterEntity(
                theater.getId(),
                theater.getName(),
                name,
                today,
                name,
                today
        );
    }

}
