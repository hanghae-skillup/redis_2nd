package com.hanghae.module.domain.repository;

import com.hanghae.module.common.dto.MovieDTO;
import com.hanghae.module.common.enums.Genre;

import java.util.List;

public interface MovieRepository {
  List<MovieDTO> findAllNowPlayingMovies(Long theaterId, String title, Genre genre);
}

