package com.root.moviesite.movie;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Transactional
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Transactional
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}