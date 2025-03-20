package com.pepponechoi.cinema.schedule.repository;

import com.pepponechoi.cinema.schedule.entity.Schedule;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);

    Optional<Schedule> findById(Long id);
    List<Schedule> findAll();

    void deleteByIdIn(Collection<Long> ids);
}
