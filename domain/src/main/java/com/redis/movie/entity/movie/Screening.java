package com.redis.movie.entity.movie;

import jakarta.persistence.*;
import com.redis.BaseEntity;
import java.time.LocalDateTime;

@Entity
@Table(name = "theater_Movie_Tm")
public class Screening extends BaseEntity {
    @Id
    private String theaterId;
    private String movieId;
    private int movieRound;
    private LocalDateTime theaterMovieStartTm;
    private LocalDateTime theaterMovieEndTm;
    private int theaterMovieHall;
    private String theaterNm;
    private String screenShowYn;
}
