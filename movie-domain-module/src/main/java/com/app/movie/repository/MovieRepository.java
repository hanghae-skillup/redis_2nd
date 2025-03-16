package com.app.movie.repository;

import com.app.movie.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository {

    List<Movie> findByReleaseDateLessThanEqual(LocalDate date);

}
