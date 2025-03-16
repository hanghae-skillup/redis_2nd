package com.hanghe.redis.movie.response

import com.hanghe.redis.movie.MovieEntity
import com.hanghe.redis.screening.ScreeningEntity
import java.time.LocalDateTime
import java.time.LocalTime

data class GetMovieScreeningResponses(
    val responses: List<GetMovieScreeningResponse>
) {

    data class GetMovieScreeningResponse(
        val title: String,
        val grade: String,
        val genre: String,
        val releaseDate: LocalDateTime,
        val thumbnailImage: String,
        val runningTime: Int,
        val screeningTimes: List<ScreeningTime>
    ) {
        companion object {
            fun fromEntity(movie: MovieEntity, screenings: List<ScreeningEntity>): GetMovieScreeningResponse {
                return GetMovieScreeningResponse(
                    title = movie.title,
                    grade = movie.grade.type,
                    genre = movie.genre.type,
                    releaseDate = movie.releaseDate,
                    thumbnailImage = movie.thumbnailImage,
                    runningTime = movie.runningTime,
                    screeningTimes = ScreeningTime.of(screenings)
                )
            }
        }

        data class ScreeningTime(
            val theaterName: String,
            val startTime: LocalTime,
            val endTime: LocalTime
        ) {
            companion object {
                fun of(screenings: List<ScreeningEntity>): List<ScreeningTime> {
                    return screenings.map { screening ->
                        of(screening)
                    }
                }

                private fun of(screening: ScreeningEntity): ScreeningTime {
                    return ScreeningTime(
                        theaterName = screening.theaterName,
                        startTime = screening.startTime,
                        endTime = screening.endTime,
                    )
                }
            }
        }
    }
}
