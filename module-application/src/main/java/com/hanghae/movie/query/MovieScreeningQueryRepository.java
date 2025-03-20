package com.hanghae.movie.query;

import com.hanghae.common.enums.SearchMatchType;
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
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieScreeningQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<MovieScreeningDto> findAllMovies() {
        return findShowingMovies(null);
    }

    public List<MovieScreeningDto> findShowingMovies(MovieScreeningSearchCondition condition) {

        QTheater qTheater = QTheater.theater;
        QScreening qScreening = QScreening.screening;
        QMovie qMovie = QMovie.movie;

        BooleanBuilder whereCondition = createMovieCondition(condition, qMovie);
        OrderSpecifier<LocalDate> releaseDateOrder = createReleaseDateOrder(condition, qMovie);

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

    private BooleanBuilder createMovieCondition(MovieScreeningSearchCondition condition, QMovie qMovie) {
        BooleanBuilder whereCondition = new BooleanBuilder();

        //전체 검색
        if (Objects.isNull(condition)) return whereCondition;

        //영화 상영 상태(기본값 : 상영 중)
        Optional.ofNullable(condition.getStatus())
                .ifPresentOrElse(
                        (status) -> whereCondition.and(qMovie.status.in(condition.getStatus())),
                        () -> whereCondition.and(qMovie.status.eq(MovieStatus.SHOWING))
                );

        //영화 장르
        Optional.ofNullable(condition.getGenre())
                .ifPresent(genre -> whereCondition.and(qMovie.genre.in(genre)));

        //영화 이름
        if (Objects.isNull(condition.getMovieName())) return whereCondition;
        Optional.ofNullable(condition.getMovieNameValue())
                .filter(name -> !name.isBlank())
                .ifPresent(name -> {
                    SearchMatchType type = condition.getMovieNameSearchType();
                    if (type == SearchMatchType.EQUAL) {
                        whereCondition.and(qMovie.title.eq(name));
                    } else if (type == SearchMatchType.LIKE) {
                        whereCondition.and(qMovie.title.like(name));
                    }
                });

        return whereCondition;
    }

    private OrderSpecifier<LocalDate> createReleaseDateOrder(MovieScreeningSearchCondition condition, QMovie qMovie) {
        if (Objects.isNull(condition)) return qMovie.releaseDate.asc();
        return condition.isReleaseDateAsc() ? qMovie.releaseDate.asc() : qMovie.releaseDate.desc();
    }
}
