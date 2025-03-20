package com.hanghae.module.core.service;

import com.hanghae.module.core.dto.MovieDTO;

import java.util.List;

public interface MovieService {
  List<MovieDTO> findAllNowPlayingMovies(Long theaterId);
}
