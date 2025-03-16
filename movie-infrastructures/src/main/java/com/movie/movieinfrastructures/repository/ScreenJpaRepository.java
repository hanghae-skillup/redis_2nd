package com.movie.movieinfrastructures.repository;

import com.movie.movieapplication.movie.entity.ScreenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenJpaRepository extends JpaRepository<ScreenEntity, Long> {

}
