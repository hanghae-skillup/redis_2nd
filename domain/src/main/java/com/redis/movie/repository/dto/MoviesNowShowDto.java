package com.redis.movie.repository.dto;

import com.redis.movie.entity.movie.Grade;
import com.redis.movie.entity.movie.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class MoviesNowShowDto {

    private String theaterId;                          // String - theaterId
    private LocalDateTime modifyDate;                   // LocalDateTime - modifyDate
    private LocalDateTime openDt;                       // LocalDateTime - openDt
    private LocalDateTime theaterMovieStartTm;          // LocalDateTime - theaterMovieStartTm
    private LocalDateTime theaterMovieEndTm;            // LocalDateTime - theaterMovieEndTm
    private String movieId;                             // String - movieId
    private String movieNm;                             // String - movieNm
    private Genre genreCd;                              // Genre - genreCd (Enum)
    private int showTm;                                 // int - showTm
    private String showYn;                              // String - showYn
    private Grade grade;                                // Grade - grade (Enum)
    private int movieRound;                             // int - movieRound
    private int theaterMovieHall;                       // int - theaterMovieHall
    private String theaterNm;                           // String - theaterNm
    private String screenShowYn;                        // String - screenShowYn
    private int imgSeq;                                 // int - imgSeq
    private String imgPath;                             // String - imgPath
    private String imgNm;                               // String - imgNm

}