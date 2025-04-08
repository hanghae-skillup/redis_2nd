package com.hanghae.module.api.controller;

import com.hanghae.module.api.dto.request.MovieRequest;
import com.hanghae.module.api.dto.response.MovieResponse;
import com.hanghae.module.common.dto.MovieDTO;
import com.hanghae.module.domain.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

  private final MovieService movieService;

  @GetMapping("/now-playing")
  public ResponseEntity<List<MovieResponse>> getNowPlayingMovies(
    MovieRequest request
    ) {
    List<MovieDTO> movies = movieService.findAllNowPlayingMovies(request.getTheaterId(), request.getTitle(),
      request.getGenre());

    List<MovieResponse> response = movies.stream()
      .map(MovieResponse::from)
      .toList();

    return ResponseEntity.ok(response);
  }
}
