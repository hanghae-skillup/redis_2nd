package com.example.movie.api.controller;


import com.example.movie.api.dto.MovieResponseDto;
import com.example.movie.api.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(@RequestParam("theater_id") Long theaterId) {
        List<MovieResponseDto> movies = movieService.getMovieByTheaterId(theaterId);
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }
}
