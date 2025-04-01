package com.pepponechoi.cinema.movie.service;

import com.pepponechoi.cinema.movie.dto.request.FindAllRequest;
import com.pepponechoi.cinema.movie.dto.response.MovieResponse;
import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.movie.repository.MovieRepository;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    @Cacheable(cacheNames = "cachenextday", key = "#request.title() + ':' + #request.genre()")
    public MovieResponses allShowingMovies(FindAllRequest request) {
        List<Movie> movies = movieRepository.findAllWithSchedule(request.toFinds());
        return new MovieResponses(movies.stream().map(MovieResponse::of).toList());
    }

    @Data
    public static class MovieResponses {
        private List<MovieResponse> movieResponses;
        public MovieResponses() {

        }
        public MovieResponses(List<MovieResponse> movieResponses) {
            this.movieResponses = movieResponses;
        }
    }
}

