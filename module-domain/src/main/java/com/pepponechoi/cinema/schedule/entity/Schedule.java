package com.pepponechoi.cinema.schedule.entity;


import com.pepponechoi.cinema.BaseEntity;
import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.screen.entity.Screen;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "schedules", indexes = {
    @Index(name = "idx_schedules_movie_start", columnList = "movie_id, start"),
    @Index(name = "idx_schedules_start", columnList = "start")
})
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(nullable = false)
    private LocalDateTime start;

    @Column(nullable = false)
    private LocalDateTime end;

    protected Schedule(Screen screen, Movie movie, LocalDateTime start, LocalDateTime end,
        String createdBy) {
        this.screen = screen;
        this.movie = movie;
        this.start = start;
        this.end = end;
        this.setCreatedBy(createdBy);
    }

    public static Schedule of(Screen screen, Movie movie, LocalDateTime start, LocalDateTime end, String createdBy) {
        return new Schedule(screen, movie, start, end, createdBy);
    }
}
