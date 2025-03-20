package com.movie.movieinfrastructures.repository;

import com.movie.movieapplication.movie.repository.TheaterRepository;
import com.movie.movieapplication.movie.domain.Theater;
import com.movie.movieapplication.movie.entity.TheaterEntity;
import jakarta.persistence.EntityManager;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TheaterRepositoryImpl implements TheaterRepository {

    private final TheaterJpaRepository theaterJpaRepository;

    private final EntityManager entityManager;

    @Override
    public Optional<Theater> findById(Long id) {
        TheaterEntity theaterEntity = entityManager.find(TheaterEntity.class, id);
        return Optional.ofNullable(theaterEntity).map(this::toDomain);
    }

    private Theater toDomain(TheaterEntity entity) {
        return Theater.of(entity.getId(), entity.getName());
    }

}
