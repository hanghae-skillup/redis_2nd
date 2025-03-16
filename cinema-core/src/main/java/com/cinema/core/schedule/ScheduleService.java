package com.cinema.core.schedule;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
	private final ScheduleReader scheduleReader;

	public ScheduleService(ScheduleReader scheduleReader) {
		this.scheduleReader = scheduleReader;
	}

	// 상영중인 영화 조회
	public List<Schedule> getOngoingSchedule() {
		return scheduleReader.getSchedule();
	}
}
