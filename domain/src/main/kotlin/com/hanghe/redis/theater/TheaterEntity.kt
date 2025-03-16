package com.hanghe.redis.theater

import com.hanghe.redis.BaseEntity
import com.hanghe.redis.movie.seat.SeatEntity
import com.hanghe.redis.screening.ScreeningEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name = "theaters")
class TheaterEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @OneToMany(mappedBy = "theater")
    val screenings: Set<ScreeningEntity> = emptySet(),

    @OneToMany(mappedBy = "theater")
    val seats: Set<SeatEntity> = emptySet()
) : BaseEntity()
