package com.movie.movieinfrastructures.repository;

import com.movie.movieapplication.movie.entity.ScheduleEntity;
import com.movie.movieapplication.movie.entity.TheaterEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleJpaRepository extends JpaRepository<ScheduleEntity, Long> {

    List<ScheduleEntity> findByTheaterId(Long theaterId);

}
