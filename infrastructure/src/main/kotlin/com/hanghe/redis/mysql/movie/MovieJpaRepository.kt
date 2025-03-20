package com.hanghe.redis.mysql.movie

import com.hanghe.redis.movie.MovieEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MovieJpaRepository : JpaRepository<MovieEntity, Long> {

    @Query(""" 
        SELECT m FROM movies m
        JOIN FETCH m.screenings s
        JOIN FETCH s.theater
        ORDER BY m.releaseDate DESC
    """)
    fun findAllByOrderByReleaseDateDesc(): List<MovieEntity>
}
