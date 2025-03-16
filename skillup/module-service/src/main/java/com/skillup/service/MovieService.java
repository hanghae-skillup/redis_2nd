package com.skillup.service;

import com.skillup.domain.Movie;
import com.skillup.domain.MovieRating;
import com.skillup.persistence.MovieRepository;
import com.skillup.service.dto.MovieResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieResponseDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movie -> new MovieResponseDTO(movie.getNo(), movie.getName(), movie.getThumnail()))
                .collect(Collectors.toList());
    }
}
