package com.pepponechoi.cinema.movie.entity;


import com.pepponechoi.cinema.entity.BaseEntity;
import com.pepponechoi.cinema.movie.enums.Genre;
import com.pepponechoi.cinema.movie.enums.Rating;
import com.pepponechoi.cinema.schedule.entity.Schedule;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Movie extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(columnDefinition = "TEXT")
    private String thumbnail;

    @Column(name = "running_time", nullable = false)
    private Integer runningTimeMin;

    @Transient
    private final List<Schedule> schedules = new ArrayList<>();

    protected Movie(String title, Rating rating, LocalDate releaseDate, Genre genre,
        String thumbnail, Integer runningTimeMin, String createdBy) {
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.thumbnail = thumbnail;
        this.runningTimeMin = runningTimeMin;
        this.setCreatedBy(createdBy);
    }

    public static Movie of(String title, Rating rating, LocalDate releaseDate, Genre genre,
        String thumbnail, Integer runningTime, String createdBy) {
        return new Movie(title, rating, releaseDate, genre, thumbnail, runningTime, createdBy);
    }

    public void clearSchedules() {
        this.schedules.clear();
    }
}
