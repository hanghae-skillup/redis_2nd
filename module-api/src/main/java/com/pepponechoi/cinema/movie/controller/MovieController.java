package com.pepponechoi.cinema.movie.controller;

import com.pepponechoi.cinema.movie.dto.request.FindAllRequest;
import com.pepponechoi.cinema.movie.dto.response.MovieResponse;
import com.pepponechoi.cinema.movie.service.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService service;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(@ModelAttribute FindAllRequest request) {
        List<MovieResponse> allMoviesIsShowing = service.allShowingMovies(request).getMovieResponses();
        return ResponseEntity.ok(allMoviesIsShowing);
    }
}
