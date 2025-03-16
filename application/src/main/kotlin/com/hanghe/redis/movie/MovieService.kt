package com.hanghe.redis.movie

import com.hanghe.redis.movie.response.GetMovieScreeningResponses
import com.hanghe.redis.mysql.movie.MovieRepository
import com.hanghe.redis.mysql.screening.ScreeningRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MovieService(
    private val movieRepository: MovieRepository,
    private val screeningRepository: ScreeningRepository
) {

    fun getAllScreeningMovies(): GetMovieScreeningResponses {
        val allMovies = movieRepository.findAllByOrderByReleaseDateDesc()

        val responses = allMovies.flatMap { movie ->
            val screenings = screeningRepository.findByMovieIdOrderByStartTime(movie.id!!)

            listOf(
                GetMovieScreeningResponses.GetMovieScreeningResponse.fromEntity(
                    movie = movie,
                    screenings = screenings
                )
            )
        }

        return GetMovieScreeningResponses(responses)
    }
}
