package org.bailey.dto;

import lombok.Builder;
import lombok.Getter;
import org.bailey.domain.enums.MovieGrade;
import org.bailey.domain.enums.MovieGenre;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private final Long scheduleId;

    // 영화 정보
    private final String title;
    private final MovieGrade grade;
    private final MovieGenre genre;
    private final int runningTime;
    private final String thumbnail;
    private final LocalDateTime releaseDate;

    // 스케줄 정보
    private final String theaterName;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    @Builder
    public ScheduleResponseDto(Long scheduleId, String title, MovieGrade grade, MovieGenre genre,
                               int runningTime, String thumbnail, LocalDateTime releaseDate,
                               String theaterName, LocalDateTime startTime, LocalDateTime endTime) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.grade = grade;
        this.genre = genre;
        this.runningTime = runningTime;
        this.thumbnail = thumbnail;
        this.releaseDate = releaseDate;
        this.theaterName = theaterName;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
