package com.hanghae.movie.query;

import com.hanghae.movie.MovieGenre;
import com.hanghae.movie.MovieGrade;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MovieScreeningDto {
    private final String name;
    private final String title;
    private final MovieGrade grade;
    private final LocalDate releaseDate;
    private final String thumbnailUrl;
    private final int runningTimeMin;
    private final MovieGenre genre;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public MovieScreeningDto(String name, String title, MovieGrade grade, LocalDate releaseDate, String thumbnailUrl, int runningTimeMin, MovieGenre genre, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.title = title;
        this.grade = grade;
        this.releaseDate = releaseDate;
        this.thumbnailUrl = thumbnailUrl;
        this.runningTimeMin = runningTimeMin;
        this.genre = genre;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}