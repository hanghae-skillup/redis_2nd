package com.hanghae.module.core.service.impl;

import com.hanghae.module.core.dto.MovieDTO;
import com.hanghae.module.core.service.MovieService;
import com.hanghae.module.domain.entity.Movie;
import com.hanghae.module.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

  private final MovieRepository movieRepository;

  @Override
  public List<MovieDTO> findAllNowPlayingMovies(Long theaterId) {
    List<Movie> movies = movieRepository.findAllNowPlayingMovies(theaterId);

    return movies.stream()
      .map(MovieDTO::from)
      .sorted(Comparator.comparing(MovieDTO::getReleaseDate).reversed())
      .collect(Collectors.toList());
  }
}
