package org.bailey.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.bailey.domain.enums.MovieGenre;
import org.bailey.domain.enums.MovieGrade;

import java.time.LocalDateTime;

@Getter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovieGrade grade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovieGenre genre;

    @Column(nullable = false)
    private int runningTime;

    private String thumbnail;

    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String updatedBy;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
