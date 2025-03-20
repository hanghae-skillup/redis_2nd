package com.cinema.api.v1.schedule;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.api.v1.schedule.dto.MovieWithSchedule;
import com.cinema.core.schedule.Schedule;
import com.cinema.core.schedule.ScheduleService;

@RestController
@RequestMapping("/v1/schedule")
public class ScheduleController {
	private final ScheduleService scheduleService;

	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@GetMapping()
	public ResponseEntity<List<MovieWithSchedule>> getOngoingSchedule() {
		List<Schedule> response = scheduleService.getOngoingSchedule();
		return ResponseEntity.ok(MovieWithSchedule.from(response));
	}
}
