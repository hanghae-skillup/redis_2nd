package com.cinema.core.schedule;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ScheduleReader {
	private final ScheduleRepository scheduleRepository;

	public ScheduleReader(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}

	public List<Schedule> getSchedule() {
		return scheduleRepository.getSchedule();
	}
}
