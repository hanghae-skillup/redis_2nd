package com.root.moviesite.movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

//    API 1개
    @GetMapping("/movie")
    public List<Movie> getMovies(){
        return movieService.findAll();
    }
}
