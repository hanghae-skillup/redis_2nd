package com.movie.movieapplication.movie.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    private Long id;

    private Long theaterId;
    private Long screenId;
    private Long movieId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Schedule(Long id, Long theaterId,
                    Long screenId, Long movieId,
                    LocalDateTime startTime, LocalDateTime endTime
    ) {
        this.id = id;
        this.theaterId = theaterId;
        this.screenId = screenId;
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Schedule of(Long id, Long theaterId,
                              Long screenId, Long movieId,
                              LocalDateTime startTime, LocalDateTime endTime
    ) {
        return new Schedule(id, theaterId, screenId, movieId, startTime, endTime);
    }

    public static Schedule of(Long id, Long theaterId,
                              Long movieId,
                              LocalDateTime startTime, LocalDateTime endTime
    ) {
        return new Schedule(id, theaterId, null, movieId, startTime, endTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule schedule)) return false;
        return id != null && id.equals(schedule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
