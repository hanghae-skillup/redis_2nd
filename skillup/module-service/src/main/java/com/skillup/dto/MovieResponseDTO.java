package com.skillup.service.dto;

import java.time.LocalDate;

import com.skillup.domain.MovieRating;
import com.skillup.service.dto.ScheduleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDTO {
    private String movieName;
    private String movieRating;
    private LocalDate releaseDate;
    private int runningTime;
    private String genre;
    private List<ScheduleDTO> schedules;
    private List<String> screenNames;  // 화면 이름 리스트 추가
}