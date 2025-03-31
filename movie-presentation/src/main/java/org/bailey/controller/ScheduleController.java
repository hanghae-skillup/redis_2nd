package org.bailey.controller;

import lombok.RequiredArgsConstructor;
import org.bailey.dto.ScheduleResponseDto;
import org.bailey.domain.entity.Schedule;
import org.bailey.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();

        return schedules.stream().map(schedule -> {
            var movie = schedule.getMovie();
            var theater = schedule.getTheater();

            return ScheduleResponseDto.builder()
                    .scheduleId(schedule.getId())
                    .title(movie.getTitle())
                    .grade(movie.getGrade())
                    .genre(movie.getGenre())
                    .runningTime(movie.getRunningTime())
                    .thumbnail(movie.getThumbnail())
                    .releaseDate(movie.getReleaseDate())
                    .theaterName(theater.getName())
                    .startTime(schedule.getStartTime())
                    .endTime(schedule.getEndTime())
                    .build();
        }).collect(Collectors.toList());
    }
}
