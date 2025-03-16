package project.redis.movie.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.redis.movie.Movie;
import project.redis.movie.adapter.MovieAdapter;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieAdapter movieAdapter;

    public void getNowPlayingMovies() {
        List<Movie> movies = movieAdapter.findMovies();
        List<Movie> nowPlayingMovies = findNowPlayingMovies(movies);

        
    }

    public List<Movie> findNowPlayingMovies(List<Movie> movies) {
        LocalDateTime today = LocalDateTime.now();

        return movies.stream()
                .filter(movie -> movie.isReleasedBefore(today))
                .sorted(Movie::compareReleaseDate)
                .collect(Collectors.toList());
    }
}
