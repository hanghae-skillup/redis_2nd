package com.hanghae.module.domain.service;


import com.hanghae.module.common.dto.MovieDTO;
import com.hanghae.module.common.enums.Genre;

import java.util.List;

public interface MovieService {
  List<MovieDTO> findAllNowPlayingMovies(Long theaterId, String ti
  , Genre genre);
}
