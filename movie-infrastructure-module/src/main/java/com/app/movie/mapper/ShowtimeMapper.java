package com.app.movie.mapper;

import com.app.movie.entity.GenreEntity;
import com.app.movie.entity.MovieEntity;
import com.app.movie.entity.ShowtimeEntity;
import com.app.movie.entity.TheaterEntity;
import com.app.movie.model.Genre;
import com.app.movie.model.Movie;
import com.app.movie.model.Showtime;
import com.app.movie.model.Theater;

import java.time.LocalDateTime;

public class ShowtimeMapper {

    // 변환 메서드: Entity -> Domain
    public static Showtime convertToDomain(ShowtimeEntity showtimeEntity) {
        Theater theater = TheaterMapper.convertToDomain(showtimeEntity.getTheater());
        Movie movie = MovieMapper.convertToDomain(showtimeEntity.getMovie());
        return new Showtime(
                showtimeEntity.getId(),
                theater,
                movie,
                showtimeEntity.getStartTime()
        );
    }

    // 변환 메서드: Domain -> Entity
    public static ShowtimeEntity convertToEntity(Showtime showtime) {
        LocalDateTime today = LocalDateTime.now();
        String adminName = "admin";

        MovieEntity movieEntity = MovieMapper.convertToEntity(showtime.getMovie());
        TheaterEntity theaterEntity = TheaterMapper.convertToEntity(showtime.getTheater());

        return new ShowtimeEntity(
                showtime.getId(),
                theaterEntity,
                movieEntity,
                showtime.getStartTime(),
                adminName,
                today,
                adminName,
                today
        );
    }

}
