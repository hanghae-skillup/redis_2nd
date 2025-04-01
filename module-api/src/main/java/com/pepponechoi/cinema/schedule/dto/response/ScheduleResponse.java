package com.pepponechoi.cinema.schedule.dto.response;

import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.schedule.entity.Schedule;
import java.time.LocalDateTime;

public record ScheduleResponse(
    Long id,
    NestedMovieResponse movie,
    LocalDateTime start,
    LocalDateTime end
) {
    public static ScheduleResponse of(Schedule schedule) {
        return new ScheduleResponse(
            schedule.getId(),
            NestedMovieResponse.of(schedule.getMovie()),
            schedule.getStart(),
            schedule.getEnd()
        );
    }

    public record NestedMovieResponse(
        Long id,
        String title
    ) {
        public static NestedMovieResponse of(Movie movie) {
            return new NestedMovieResponse(movie.getId(), movie.getTitle());
        }
    }
}
