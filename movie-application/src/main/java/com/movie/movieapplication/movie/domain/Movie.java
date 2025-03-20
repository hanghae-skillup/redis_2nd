package com.movie.movieapplication.movie.domain;

import com.movie.movieapplication.enums.Rating;
import com.movie.movieapplication.enums.Genre;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class Movie {

    private Long id;
    private String title;
    private LocalDateTime releasedAt;
    private String thumbnailUrl;
    private String runningTime;
    private Rating rating;
    private Genre genre;

    public Movie(Long id, String title,
                 LocalDateTime releasedAt, String thumbnailUrl,
                 String runningTime, Rating rating,
                 Genre genre
    ) {
        this.id = id;
        this.title = title;
        this.releasedAt = releasedAt;
        this.thumbnailUrl = thumbnailUrl;
        this.runningTime = runningTime;
        this.rating = rating;
        this.genre = genre;
    }

    public static Movie of(Long id, String title,
                 LocalDateTime releasedAt, String thumbnailUrl,
                 String runningTime, Rating rating,
                 Genre genre
    ) {
        return new Movie(id, title, releasedAt, thumbnailUrl, runningTime, rating, genre);
    }
}
