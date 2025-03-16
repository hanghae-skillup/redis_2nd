package com.app.movie.presentation;

import com.app.movie.application.MovieService;
import com.app.movie.presentation.dto.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieRestController {

    MovieService movieService;

    @Autowired
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public List<MovieResponseDto> getMovies() {
        return movieService.findAllMovies();
    }
}
