package com.hanghae.module.persistence.repository.impl;

import com.hanghae.module.domain.entity.Movie;
import com.hanghae.module.domain.repository.MovieRepository;
import com.hanghae.module.persistence.repository.querydsl.MovieCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {
  private final MovieCustomRepository movieCustomRepository;

  @Override
  public List<Movie> findAllNowPlayingMovies(Long theaterId) {
    return movieCustomRepository.findAllNowPlayingMovies(theaterId);
  }
}
