package com.redis.reservation.entity;

import com.redis.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "movie_reser")
public class Reservation extends BaseEntity {
    @Id
    private String reserId;
    private String seatId;
    private String loginId;
    private LocalDateTime reserTm;
    private LocalDateTime reserCd;
}
