package com.pepponechoi.cinema.movie.service;

import com.pepponechoi.cinema.movie.dto.request.FindAllRequest;
import com.pepponechoi.cinema.movie.service.MovieServiceImpl.MovieResponses;

public interface MovieService {
    MovieResponses allShowingMovies(FindAllRequest request);
}
