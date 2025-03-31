package org.bailey.repository;

import org.bailey.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s JOIN FETCH s.movie JOIN FETCH s.theater")
    List<Schedule> findAllWithMovieAndTheater();
}
