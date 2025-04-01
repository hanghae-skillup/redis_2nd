package com.pepponechoi.cinema.movie.repository;

import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.movie.repository.querydsl.MovieQueryDslRepository;
import java.util.Collection;
import java.util.Optional;

public interface MovieRepository extends MovieQueryDslRepository {
    Movie save(Movie movie);
    Optional<Movie> findById(Long id);

    void deleteByIdIn(Collection<Long> ids);
}
