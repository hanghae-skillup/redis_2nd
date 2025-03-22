package com.hanghae.module.core.service.impl;

import com.hanghae.module.common.dto.MovieDTO;
import com.hanghae.module.core.service.MovieService;
import com.hanghae.module.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

  private final MovieRepository movieRepository;

  @Override
  public List<MovieDTO> findAllNowPlayingMovies(Long theaterId) {
    return movieRepository.findAllNowPlayingMovies(theaterId);
  }
}
