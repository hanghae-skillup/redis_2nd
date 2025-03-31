package org.bailey.repository;

import org.bailey.domain.entity.Schedule;
import org.bailey.domain.repository.ScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final JpaScheduleRepository jpa; // ✅ domain 레이어만 의존

    public ScheduleRepositoryImpl(JpaScheduleRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<Schedule> findAll() {
        return jpa.findAll();
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public List<Schedule> findAllWithMovieAndTheater() {
        return jpa.findAllWithMovieAndTheater();
    }
}
