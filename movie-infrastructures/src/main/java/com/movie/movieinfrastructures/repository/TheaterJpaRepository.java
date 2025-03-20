package com.movie.movieinfrastructures.repository;

import com.movie.movieapplication.movie.entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterJpaRepository extends JpaRepository<TheaterEntity, Long> {
}
