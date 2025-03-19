package com.hanghae.movie;

import com.hanghae.common.entity.BaseEntity;
import com.hanghae.common.vo.PositiveNumber;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGrade grade;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "url", column = @Column(name = "thumbnail_url"))
    )
    @Column(nullable = false)
    private UrlString thumbnailUrl;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "value", column = @Column(name = "running_time"))
    )
    @Column(nullable = false)
    private PositiveNumber runningTimeMin;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    public Movie(String title, MovieGrade grade, LocalDate releaseDate, String thumbnailUrl, int runningTimeMin, MovieGenre genre) {
        this(null, title, grade, releaseDate, new UrlString(thumbnailUrl), new PositiveNumber(runningTimeMin), genre);
    }

    public Movie(String title, MovieGrade grade, LocalDate releaseDate, UrlString thumbnailUrl, PositiveNumber runningTimeMin, MovieGenre genre) {
        this(null, title, grade, releaseDate, thumbnailUrl, runningTimeMin, genre);
    }

    public Movie(Long id, String title, MovieGrade grade, LocalDate releaseDate, UrlString thumbnailUrl, PositiveNumber runningTimeMin, MovieGenre genre) {
        this.id = id;
        this.title = title;
        this.grade = grade;
        this.releaseDate = releaseDate;
        this.thumbnailUrl = thumbnailUrl;
        this.runningTimeMin = runningTimeMin;
        this.genre = genre;
    }
}
