package com.pepponechoi.cinema.movie.service;

import com.pepponechoi.cinema.movie.dto.response.MovieResponse;
import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.movie.repository.MovieRepository;
import com.pepponechoi.cinema.schedule.entity.Schedule;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<MovieResponse> findAllMoviesIsShowing() {
        List<Object[]> results = movieRepository.findAllWithSchedule();
        Map<Long, Movie> movieMap = results.stream().map(result -> (Movie) result[0])
            .collect(Collectors.toMap(Movie::getId,
                movie -> {
                movie.clearSchedules();
                return movie;
                }, (e, r) -> e));

        results.stream().filter(result -> result[1] instanceof Schedule).forEach(
            result -> {
                Movie movie = movieMap.get(((Movie) result[0]).getId());
                ((Schedule) result[1]).link();
            }
        );
        return movieMap.values().stream().map(MovieResponse::of).toList();
    }
}

