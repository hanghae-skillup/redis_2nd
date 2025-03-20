package com.pepponechoi.cinema.schedule.repository;

import com.pepponechoi.cinema.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleJpaRepository extends JpaRepository<Schedule, Long>, ScheduleRepository {

}
