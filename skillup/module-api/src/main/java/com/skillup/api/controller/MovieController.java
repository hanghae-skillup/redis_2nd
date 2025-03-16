package com.skillup.api.controller;

import com.skillup.service.*;
import com.skillup.service.dto.MovieResponseDTO;

// import com.skillup.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<MovieResponseDTO> getMovies() {
        //TODO : 조인을 통해서 조회 쿼리 수정필요
        return movieService.getAllMovies();
    }
}