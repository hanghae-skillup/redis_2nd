package com.pepponechoi.cinema.movie.entity;


import com.pepponechoi.cinema.BaseEntity;
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
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies", indexes = {
    @Index(name = "idx_movies_title_genre_release_date", columnList = "title, genre, release_date"),
    @Index(name = "idx_movies_title", columnList = "title"),
    @Index(name = "idx_movies_genre", columnList = "genre"),
    @Index(name = "idx_movies_release_date", columnList = "release_date"),
})
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

    @OneToMany(mappedBy = "movie")
    private List<Schedule> schedules = new ArrayList<>();

    protected Movie(String title, Rating rating, LocalDate releaseDate, Genre genre,
        String thumbnail, Integer runningTimeMin, String createdBy, Collection<Schedule> schedules) {
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.thumbnail = thumbnail;
        this.runningTimeMin = runningTimeMin;
        if (schedules != null) {
            this.schedules.addAll(schedules);
        }
        this.setCreatedBy(createdBy);
    }

    public static Movie of(String title, Rating rating, LocalDate releaseDate, Genre genre,
        String thumbnail, Integer runningTime, String createdBy, Collection<Schedule> schedules) {
        return new Movie(title, rating, releaseDate, genre, thumbnail, runningTime, createdBy, schedules);
    }
}
