package com.skillup.service.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String screenName;
}