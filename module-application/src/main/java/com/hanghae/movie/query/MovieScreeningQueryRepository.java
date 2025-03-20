package com.hanghae.movie.query;

import com.hanghae.movie.QMovie;
import com.hanghae.theater.QScreening;
import com.hanghae.theater.QTheater;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieScreeningQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<MovieScreeningDto> findShowingMovies() {

        QTheater qTheater = QTheater.theater;
        QScreening qScreening = QScreening.screening;
        QMovie qMovie = QMovie.movie;

        return queryFactory.select(Projections.constructor(
                        MovieScreeningDto.class,
                        qTheater.name,
                        qMovie.title,
                        qMovie.grade,
                        qMovie.releaseDate,
                        qMovie.thumbnailUrl.url,
                        qMovie.runningTimeMin.value,
                        qMovie.genre,
                        qScreening.screeningTime.startTime,
                        qScreening.screeningTime.endTime
                ))
                .from(qTheater)
                .join(qTheater.screenings, qScreening)
                .join(qMovie).on(qScreening.movieId.eq(qMovie.id))
                .orderBy(qMovie.releaseDate.asc(), qMovie.id.asc(), qScreening.screeningTime.startTime.asc())
                .fetch();
    }
}
