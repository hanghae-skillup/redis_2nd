package com.hanghe.redis.mysql.movie

import com.hanghe.redis.movie.MovieEntity

interface MovieRepository {

    fun findAllByOrderByReleaseDateDesc(): List<MovieEntity>
}
