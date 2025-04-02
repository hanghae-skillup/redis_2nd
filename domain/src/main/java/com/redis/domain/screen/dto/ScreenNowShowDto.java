package com.redis.domain.screen.dto;

import com.redis.domain.movie.entity.Grade;
import com.redis.domain.movie.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScreenNowShowDto {

    private Long cinemaId;
    private LocalDateTime modifyDate;
    private LocalDateTime openDate;
    private LocalDateTime movieStartTime;
    private LocalDateTime movieEndTime;
    private Long movieId;
    private String movieNm;
    private Genre genreCd;
    private Integer showTimeMin;
    private Boolean showYn;
    private Grade grade;
    private Integer movieRound;
    private Integer movieHall;
    private String cinemaNm;
    private Boolean screenShowYn;
    private Long imgSeq;
    private String imgPath;
    private String imgNm;
}