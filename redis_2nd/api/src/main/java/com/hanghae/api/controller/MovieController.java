package com.hanghae.api.controller;

import com.hanghae.api.dto.MovieResponseDto;
import com.hanghae.api.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/now-playing")
    public List<MovieResponseDto> getNowPlayingMovies() {
        return movieService.getMovies();
    }
}
