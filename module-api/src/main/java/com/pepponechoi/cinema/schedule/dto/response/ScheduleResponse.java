package com.pepponechoi.cinema.schedule.dto.response;

import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.schedule.entity.Schedule;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ScheduleResponse {
    private Long id;
    private NestedMovieResponse movie;
    private LocalDateTime start;
    private LocalDateTime end;

    public ScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.movie = new NestedMovieResponse(schedule.getMovie());
        this.start = schedule.getStart();
        this.end = schedule.getEnd();
    }

    @Data
    private static class NestedMovieResponse {
        private Long id;
        private String title;
        public NestedMovieResponse(Movie movie) {
            this.id = movie.getId();
            this.title = movie.getTitle();
        }
    }
}
