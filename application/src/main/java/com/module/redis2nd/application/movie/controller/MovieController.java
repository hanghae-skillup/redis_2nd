package com.module.redis2nd.application.movie.controller;

import com.module.redis2nd.domain.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/screenings")
    public ResponseEntity getScreeningMovies() {
        return ResponseEntity.ok(movieService.getScreeningMovies());
    }
}
