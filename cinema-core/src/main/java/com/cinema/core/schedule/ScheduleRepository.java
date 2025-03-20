package com.cinema.core.schedule;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository {
	List<Schedule> getSchedule();
}
