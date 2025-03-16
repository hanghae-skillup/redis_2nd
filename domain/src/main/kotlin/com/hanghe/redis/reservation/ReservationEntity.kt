package com.hanghe.redis.reservation

import com.hanghe.redis.BaseEntity
import com.hanghe.redis.movie.seat.SeatEntity
import com.hanghe.redis.screening.ScreeningEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "reservations")
class ReservationEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screening_id", nullable = false)
    val screening: ScreeningEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    val seat: SeatEntity,

    // TODO: 예매한 사용자 정보 추가
) : BaseEntity()
