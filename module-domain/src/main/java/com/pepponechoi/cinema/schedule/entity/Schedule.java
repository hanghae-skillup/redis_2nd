package com.pepponechoi.cinema.schedule.entity;


import com.pepponechoi.cinema.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.screen.entity.Screen;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "schedules")
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

    public void link() {
        this.getMovie().getSchedules().add(this);
    }
}
