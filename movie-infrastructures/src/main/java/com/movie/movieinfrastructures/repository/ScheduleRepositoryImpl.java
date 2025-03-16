package com.movie.movieinfrastructures.repository;

import com.movie.movieapplication.movie.repository.ScheduleRepository;
import com.movie.movieapplication.movie.domain.Schedule;
import com.movie.movieapplication.movie.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final ScheduleJpaRepository scheduleJpaRepository;
    private final TheaterJpaRepository theaterJpaRepository;

    @Override
    public List<Schedule> getSchedules(Long theaterId) {
        return scheduleJpaRepository.findByTheaterId(theaterId).stream()
                .map(ScheduleMapper::from)
                .toList();
    }
}
