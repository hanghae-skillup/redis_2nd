package com.movie.movieapplication.movie.entity;

import com.movie.movieapplication.enums.Rating;
import com.movie.movieapplication.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "movie")
public class MovieEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;                       // 영화 제목

    @Enumerated(EnumType.STRING)
    @Column
    private Rating rating;              // 영상물 등급

    @Enumerated(EnumType.STRING)
    @Column
    private Genre genre;                        // 장르

    private LocalDateTime releasedAt;           // 개봉일

    @Column
    private String thumbnailUrl;                // 썸네일 이미지 url

    @Column
    private String runningTime;                 // 러닝 타임

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieEntity movieEntity)) return false;
        return id != null && id.equals(movieEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
