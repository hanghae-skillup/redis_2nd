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
    private String title;

    @Enumerated(EnumType.STRING)
    @Column
    private Rating rating;
    @Enumerated(EnumType.STRING)
    @Column
    private Genre genre;
    @Column
    private LocalDateTime releasedAt;
    @Column
    private String thumbnailUrl;
    @Column
    private String runningTime;

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
