package com.example.movie.domain.entity;

import com.example.movie.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @Builder
    public Schedule(Movie movie, Theater theater, LocalDateTime startAt, LocalDateTime endAt) {
        this.movie = movie;
        this.theater = theater;
        this.startAt = startAt;
        this.endAt = endAt;
    }
}
