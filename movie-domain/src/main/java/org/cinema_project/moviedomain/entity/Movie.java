package org.cinema_project.moviedomain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "movie")
@Getter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;         // 영화 제목
    private String rating;        // 영상물 등급
    private String genre;         // 영화 장르
    private LocalDateTime releaseDate; // 개봉일
    private String posterUrl;     // 썸네일 이미지 URL
    private int runningTime;      // 러닝 타임 (분)

    public Movie(String title, String rating, String genre,
                 LocalDateTime releaseDate, String posterUrl, int runningTime) {
        this.title = title;
        this.rating = rating;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.posterUrl = posterUrl;
        this.runningTime = runningTime;
    }
}

