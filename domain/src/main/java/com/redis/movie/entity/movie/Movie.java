package com.redis.movie.entity.movie;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import com.redis.BaseEntity;

@Entity
@Table(name = "movie_Info")
public class Movie extends BaseEntity {
    @Id
    private String movieId;
    @Enumerated(EnumType.STRING)
    private Genre genreCd;
    @Enumerated(EnumType.STRING)
    private Grade grade;

    private String movieNm;
    private int showTm;
    private String showYn;
    private LocalDateTime  openDt;
    private int movieRound;
    private int theaterMovieHall;
    private String theaterNm;
    private int thumImg;
    private LocalDateTime modifyDate;
    private String imgPath;
    private String imgNm;





}
