package com.example.movie.api.dto;

import com.example.movie.domain.entity.Schedule;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ScheduleResponseDto(Long scheduleId, String theaterName, LocalDateTime startAt,
                                  LocalDateTime endAt) {

    @Builder
    public ScheduleResponseDto {
    }

    public static ScheduleResponseDto fromEntity(Schedule schedule) {
        return ScheduleResponseDto.builder()
                .scheduleId(schedule.getId())
                .theaterName(schedule.getTheater().getTheaterName())
                .startAt(schedule.getStartAt())
                .endAt(schedule.getEndAt())
                .build();
    }
}
