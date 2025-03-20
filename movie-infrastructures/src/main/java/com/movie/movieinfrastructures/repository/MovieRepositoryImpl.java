package com.movie.movieinfrastructures.repository;

import com.movie.movieapplication.movie.repository.MovieRepository;
import com.movie.movieapplication.movie.domain.Movie;
import com.movie.movieapplication.movie.entity.MovieEntity;
import jakarta.persistence.EntityManager;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    private final EntityManager entityManager;

    @Override
    public Optional<Movie> findById(Long id) {
        MovieEntity movieEntity = entityManager.find(MovieEntity.class, id);
        return Optional.ofNullable(movieEntity).map(this::toDomain);
    }

    private Movie toDomain(MovieEntity entity) {
        return Movie.of(
                entity.getId(),
                entity.getTitle(),
                entity.getReleasedAt(),
                entity.getThumbnailUrl(),
                entity.getRunningTime(),
                entity.getRating(),
                entity.getGenre()
        );
    }
}
