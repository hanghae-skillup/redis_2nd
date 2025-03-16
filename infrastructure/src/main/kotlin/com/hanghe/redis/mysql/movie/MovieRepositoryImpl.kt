package com.hanghe.redis.mysql.movie

import com.hanghe.redis.movie.MovieEntity
import org.springframework.stereotype.Repository

@Repository
class MovieRepositoryImpl(
    private val movieJpaRepository: MovieJpaRepository
) : MovieRepository {

    override fun findAllByOrderByReleaseDateDesc(): List<MovieEntity> {
        return movieJpaRepository.findAllByOrderByReleaseDateDesc()
    }
}
