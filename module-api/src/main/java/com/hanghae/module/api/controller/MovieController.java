package com.hanghae.module.api.controller;

import com.hanghae.module.api.dto.response.MovieResponse;
import com.hanghae.module.common.dto.MovieDTO;
import com.hanghae.module.common.enums.Genre;
import com.hanghae.module.core.service.MovieService;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

  private final MovieService movieService;

  @GetMapping("/now-playing")
  public ResponseEntity<List<MovieResponse>> getNowPlayingMovies(
    @RequestParam(required = false) Long theaterId,
    @Size(max = 255, message = "영화 제목은 255자를 초과할 수 없습니다.")
    @RequestParam(required = false) String title,
    @RequestParam(required = false) Genre genre
    ) {
    List<MovieDTO> movies = movieService.findAllNowPlayingMovies(theaterId, title, genre);

    List<MovieResponse> response = movies.stream()
      .map(MovieResponse::from)
      .toList();

    return ResponseEntity.ok(response);
  }
}
