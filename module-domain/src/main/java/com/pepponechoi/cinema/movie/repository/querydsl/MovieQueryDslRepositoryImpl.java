package com.pepponechoi.cinema.movie.repository.querydsl;

import static com.pepponechoi.cinema.movie.entity.QMovie.movie;
import static com.pepponechoi.cinema.schedule.entity.QSchedule.schedule;

import com.pepponechoi.cinema.movie.dto.FindMovies;
import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.movie.enums.Genre;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MovieQueryDslRepositoryImpl implements MovieQueryDslRepository {

    private final JPAQueryFactory queryFactory;
    @Override
    public List<Movie> findAllWithSchedule(FindMovies findMovies) {
        BooleanBuilder whereClause = new BooleanBuilder();

        LocalDateTime now = LocalDateTime.now();
        String title = findMovies.title();
        Genre genre = Genre.valueOf(findMovies.genre());

        return queryFactory
            .selectFrom(movie)
            .join(movie.schedules, schedule).fetchJoin()
            .leftJoin(schedule.screen).fetchJoin()
            .where(eqTitle(title), eqGenre(genre), schedule.start.after(now))
            .orderBy(schedule.start.asc(), movie.releaseDate.desc())
            .fetch();
    }

    private BooleanExpression eqTitle(String title) {
        if (StringUtils.isNullOrEmpty(title) || title.trim().isEmpty()) {
            return null;
        }
        return movie.title.eq(title.trim().toLowerCase());
    }

    private BooleanExpression eqGenre(Genre genre) {
        if (genre == null) {
            return null;
        }
        return movie.genre.eq(genre);
    }
}
