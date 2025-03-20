package com.hanghae.movie.query;

import com.hanghae.movie.MovieStatus;
import com.hanghae.movie.QMovie;
import com.hanghae.theater.QScreening;
import com.hanghae.theater.QTheater;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieScreeningQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<MovieScreeningDto> findShowingMovies() {
        return findShowingMovies(null, true);
    }

    public List<MovieScreeningDto> findShowingMovies(List<MovieStatus> status, boolean isAsc) {

        QTheater qTheater = QTheater.theater;
        QScreening qScreening = QScreening.screening;
        QMovie qMovie = QMovie.movie;

        BooleanBuilder whereCondition = createWhereCondition(status, qMovie);
        OrderSpecifier<LocalDate> releaseDateOrder = createReleaseDateOrder(isAsc, qMovie);

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
                .where(whereCondition)
                .orderBy(releaseDateOrder, qMovie.id.asc(), qScreening.screeningTime.startTime.asc())
                .fetch();
    }

    private BooleanBuilder createWhereCondition(List<MovieStatus> status, QMovie qMovie) {
        BooleanBuilder whereCondition = new BooleanBuilder();
        if (status != null) {
            whereCondition.and(qMovie.status.in(status));
        }
        return whereCondition;
    }

    private OrderSpecifier<LocalDate> createReleaseDateOrder(boolean isAsc, QMovie qMovie) {
        return isAsc ? qMovie.releaseDate.asc() : qMovie.releaseDate.desc();
    }
}
