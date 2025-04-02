package com.redis.domain.screen.entity;

import com.redis.domain.movie.entity.MovieInfo;
import com.redis.domain.reservation.entity.Reservation;
import jakarta.persistence.*;
import com.redis.domain.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cinema_movie_time")
public class Screen extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cinemaId;

    private Long movieId;
    private Integer movieRound; //영화회차
    private LocalDateTime movieStartTime; // 영화시작시간
    private LocalDateTime movieEndTime; // 영화종료시간
    private Integer movieHall; //영화상영관
    private String cinemaNm; //영화관이름
    private Boolean screenShowYn; //영화관시간표보임여부
    private LocalDateTime createDate; //생성일
    private LocalDateTime modifyDate; //수정일


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieInfo")
    private MovieInfo movieInfo;

}
