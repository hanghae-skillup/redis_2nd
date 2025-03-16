package com.app.movie.adapter;

import com.app.movie.entity.GenreEntity;
import com.app.movie.entity.MovieEntity;
import com.app.movie.mapper.MovieMapper;
import com.app.movie.model.Genre;
import com.app.movie.model.Movie;
import com.app.movie.repository.MovieJpaRepository;
import com.app.movie.repository.MovieRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MovieRepositoryAdapter implements MovieRepository {

    private final MovieJpaRepository movieJpaRepository;

    public MovieRepositoryAdapter(MovieJpaRepository movieJpaRepository) {
        this.movieJpaRepository = movieJpaRepository;
    }


    @Override
    public List<Movie> findByReleaseDateLessThanEqual(LocalDate date) {
        List<MovieEntity> movieEntities = movieJpaRepository.findByReleaseDateLessThanEqual(date);
        List<Movie> movies = movieEntities.stream().map(MovieMapper::convertToDomain).toList();
        return movies;
    }

}
