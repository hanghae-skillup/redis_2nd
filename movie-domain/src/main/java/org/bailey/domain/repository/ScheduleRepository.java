package org.bailey.domain.repository;

import org.bailey.domain.entity.Schedule;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    List<Schedule> findAll();
    Optional<Schedule> findById(Long id);
    List<Schedule> findAllWithMovieAndTheater();
}