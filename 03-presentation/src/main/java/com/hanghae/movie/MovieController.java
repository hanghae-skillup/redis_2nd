package com.hanghae.movie;

import com.hanghae.movie.dto.MovieCreateRequest;
import com.hanghae.movie.dto.MovieCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieCreateResponse> create(@RequestBody MovieCreateRequest request) {
        MovieCreateResponse response = movieService.save(request);
        return ResponseEntity.created(URI.create("/api/movies/" + response.id()))
                .body(response);
    }
}