package com.app.movie.repository;

import com.app.movie.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {

    List<MovieEntity> findByReleaseDateLessThanEqual(LocalDate localDate);

}
