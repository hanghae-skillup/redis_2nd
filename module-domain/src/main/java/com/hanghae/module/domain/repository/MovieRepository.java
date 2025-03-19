package com.hanghae.module.domain.repository;

import com.hanghae.module.domain.entity.Movie;

import java.util.List;

public interface MovieRepository {
  List<Movie> findAllNowPlayingMovies(Long theaterId);
}

