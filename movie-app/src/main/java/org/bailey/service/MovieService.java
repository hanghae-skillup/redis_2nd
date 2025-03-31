package org.bailey.service;

import org.bailey.domain.entity.Movie;
import org.bailey.domain.exception.movie.MovieListNotFoundException;
import org.bailey.domain.exception.movie.MovieNotFoundException;
import org.bailey.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies()  {
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            throw new MovieListNotFoundException();
        }
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }
}
