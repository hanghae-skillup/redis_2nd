package com.movie.movieinfrastructures.repository;

import com.movie.movieapplication.movie.repository.ScreenRepository;
import com.movie.movieapplication.movie.domain.Screen;
import com.movie.movieapplication.movie.entity.ScreenEntity;
import jakarta.persistence.EntityManager;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ScreenRepositoryImpl implements ScreenRepository {

    private final ScreenJpaRepository screenJpaRepository;
    private final EntityManager entityManager;
    @Override
    public Optional<Screen> findById(Long id) {
        ScreenEntity screenEntity = entityManager.find(ScreenEntity.class, id);
        return Optional.ofNullable(screenEntity).map(this::toDomain);
    }

    private Screen toDomain(ScreenEntity entity) {
        return Screen.of(entity.getId(), entity.getName(), entity.getTheaterId());
    }
}
