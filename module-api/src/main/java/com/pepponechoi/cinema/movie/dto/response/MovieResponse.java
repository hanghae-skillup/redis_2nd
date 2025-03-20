package com.pepponechoi.cinema.movie.dto.response;

import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.schedule.entity.Schedule;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record MovieResponse(
    Long id,
    String title,
    String rating,
    String ratingCode,
    LocalDate releaseDate,
    String genre,
    String genreCode,
    String thumbnail,
    Integer runningTimeMin,
    Set<NestedScheduleResponse> schedule
) {
    public static MovieResponse of(final Movie movie) {
        return new MovieResponse(
            movie.getId(),
            movie.getTitle(),
            movie.getRating().getValue(),
            movie.getRating().getCode(),
            movie.getReleaseDate(),
            movie.getGenre().getValue(),
            movie.getGenre().getCode(),
            movie.getThumbnail(),
            movie.getRunningTimeMin(),
            movie.getSchedules().stream()
            .sorted(Comparator.comparing(Schedule::getStart))
            .map(NestedScheduleResponse::of)
            .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }
    private record NestedScheduleResponse(
        Long id,
        Long screenId,
        String screenName,
        LocalDateTime start,
        LocalDateTime end
    ) {
        public static NestedScheduleResponse of(final Schedule schedule) {
            return new NestedScheduleResponse(
                schedule.getId(),
                schedule.getScreen().getId(),
                schedule.getScreen().getName(),
                schedule.getStart(),
                schedule.getEnd()
            );
        }
    }
}
