package com.hanghae.movie.dto;

import com.hanghae.movie.MovieGenre;
import com.hanghae.movie.MovieGrade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MovieScreeningDto(
        String name,
        String title,
        MovieGrade grade,
        LocalDate releaseDate,
        String thumbnailUrl,
        int runningTime,
        MovieGenre genre,
        LocalDateTime startTime,
        LocalDateTime endTime
){}
