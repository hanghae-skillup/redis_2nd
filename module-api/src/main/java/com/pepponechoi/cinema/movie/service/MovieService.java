package com.pepponechoi.cinema.movie.service;

import com.pepponechoi.cinema.movie.dto.response.MovieResponse;
import java.util.List;

public interface MovieService {
    List<MovieResponse> findAllMoviesIsShowing();
}
