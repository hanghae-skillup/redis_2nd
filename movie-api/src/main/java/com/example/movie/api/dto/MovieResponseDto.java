package com.example.movie.api.dto;

import com.example.movie.domain.entity.Movie;
import com.example.movie.domain.entity.Schedule;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieResponseDto {
    private final Long movieId;
    private final String title;
    private final String thumbnailUrl;
    private final String genre;
    private final String rating;
    private final LocalDate releaseDate;
    private final int runningTime;
    private final List<ScheduleResponseDto> schedules;

    public static MovieResponseDto fromEntity(Movie movie, List<Schedule> schedules) {
        return MovieResponseDto.builder()
                .movieId(movie.getId())
                .title(movie.getTitle())
                .thumbnailUrl(movie.getThumbnailUrl())
                .genre(movie.getGenre().name())
                .rating(movie.getRating().name())
                .releaseDate(movie.getReleaseDate())
                .runningTime(movie.getRunningTime())
                .schedules(schedules.stream().map(ScheduleResponseDto::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}