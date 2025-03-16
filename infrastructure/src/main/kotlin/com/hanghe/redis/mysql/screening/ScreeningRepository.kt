package com.hanghe.redis.mysql.screening

import com.hanghe.redis.screening.ScreeningEntity

interface ScreeningRepository {

    fun findByMovieIdOrderByStartTime(movieId: Long): List<ScreeningEntity>
}
