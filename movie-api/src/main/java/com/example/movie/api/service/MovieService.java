package com.example.movie.api.service;

import com.example.movie.api.dto.MovieResponseDto;
import com.example.movie.domain.entity.Movie;
import com.example.movie.domain.repository.movie.MovieRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<MovieResponseDto> getMovieByTheaterId(Long theaterId) {

        List<Movie> movies = movieRepository.findNowShowingMovies(theaterId);

        List<MovieResponseDto> movieResponseDtos = movies.stream()
                .map(movie -> MovieResponseDto.fromEntity(movie, movie.getSchedules())).toList();

        return movieResponseDtos;
    }
}
