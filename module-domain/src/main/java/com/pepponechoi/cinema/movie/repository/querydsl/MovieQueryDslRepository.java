package com.pepponechoi.cinema.movie.repository.querydsl;

import com.pepponechoi.cinema.movie.dto.FindMovies;
import com.pepponechoi.cinema.movie.entity.Movie;
import java.util.List;

public interface MovieQueryDslRepository {
    List<Movie> findAllWithSchedule(FindMovies findMovies);
}
