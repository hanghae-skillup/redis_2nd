package com.redis.domain.reservation.entity;

import com.redis.domain.BaseEntity;
import com.redis.domain.screen.entity.Screen;
import com.redis.domain.user.entity.MovieUser;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Entity
@Table(name = "movie_reser")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserId;

    private String seatId;
    private String userId;
    private String reserCd;
    private String loginId;

    @CreatedDate
    private LocalDateTime reserTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movieUser")
    private MovieUser movieUser;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen")
    private Screen screen;



}
