package com.hanghe.redis.mysql.screening

import com.hanghe.redis.screening.ScreeningEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ScreeningJpaRepository : JpaRepository<ScreeningEntity, Long> {

    fun findByMovieIdOrderByStartTime(movieId: Long): List<ScreeningEntity>
}
