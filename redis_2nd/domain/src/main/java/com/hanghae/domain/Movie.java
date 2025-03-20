package com.hanghae.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private LocalDate releaseDate;
    private String thumbnailUrl;
    private int runningTime;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}
