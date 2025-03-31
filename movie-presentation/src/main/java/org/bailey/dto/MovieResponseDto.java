package org.bailey.dto;

import lombok.Builder;
import lombok.Getter;
import org.bailey.domain.enums.MovieGenre;
import org.bailey.domain.enums.MovieGrade;

import java.time.LocalDateTime;

@Getter
public class MovieResponseDto {
    private final Long id;
    private final String title;
    private final MovieGrade grade;
    private final MovieGenre genre;
    private final int runningTime;
    private final String thumbnail;
    private final LocalDateTime releaseDate;

    @Builder
    public MovieResponseDto(Long id, String title, MovieGrade grade, MovieGenre genre,
                            int runningTime, String thumbnail, LocalDateTime releaseDate) {
        this.id = id;
        this.title = title;
        this.grade = grade;
        this.genre = genre;
        this.runningTime = runningTime;
        this.thumbnail = thumbnail;
        this.releaseDate = releaseDate;
    }
}