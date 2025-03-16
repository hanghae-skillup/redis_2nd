package project.redis.movie.adapter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.movie.Movie;
import project.redis.movie.entity.MovieEntity;
import project.redis.movie.mapper.MovieMapper;
import project.redis.movie.repository.MovieRepository;

@Component
@RequiredArgsConstructor
public class MovieAdapter {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public List<Movie> findMovies() {
        List<MovieEntity> movieEntities = movieRepository.findAll();
        return movieEntities.stream()
                .map(movieMapper::toDomain)
                .toList();
    }
}
