package com.movie.movieapplication.movie.repository;

import com.movie.movieapplication.movie.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    Optional<Movie> findById(Long id);

}
