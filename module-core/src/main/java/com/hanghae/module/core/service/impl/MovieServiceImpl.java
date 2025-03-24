package com.hanghae.module.core.service.impl;

import com.hanghae.module.common.dto.MovieDTO;
import com.hanghae.module.common.enums.Genre;
import com.hanghae.module.core.service.MovieService;
import com.hanghae.module.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

  private final MovieRepository movieRepository;

  @Cacheable(value = "movies",
      keyGenerator = "movieCacheKeyGenerator"
  )
  @Override
  public List<MovieDTO> findAllNowPlayingMovies(Long theaterId, String title,
                                                Genre genre) {
    return movieRepository.findAllNowPlayingMovies(theaterId, title, genre);
  }
}
