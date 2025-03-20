package com.hanghae.module.persistence.repository.querydsl;

import com.hanghae.module.domain.entity.Movie;
import com.hanghae.module.domain.entity.QMovie;
import com.hanghae.module.domain.entity.QScreening;
import com.hanghae.module.domain.entity.QTheater;
import com.hanghae.module.domain.enums.Genre;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieCustomRepository {

  private final JPAQueryFactory queryFactory;

  /**
   * 상영 중인 영화를 개봉일 기준으로 정렬하여 조회
   */
  public List<Movie> findAllNowPlayingMovies(Long theaterId) {
    QMovie movie = QMovie.movie;
    QScreening screening = QScreening.screening;
    QTheater theater = QTheater.theater;

    LocalDate today = LocalDate.now();

    return queryFactory
      .selectFrom(movie)
      .distinct()
      .join(movie.screenings, screening).fetchJoin()
      .join(screening.theater, theater).fetchJoin()
      .where(
        theater.id.eq(theaterId),
        screening.screeningDate.goe(today)
      )
      .orderBy(movie.releaseDate.desc())
      .fetch();
  }

  /**
   * 상영 중인 영화를 장르로 필터링하여 조회
   */
  public List<Movie> findNowPlayingMoviesByGenre(Long theaterId, Genre genre) {
    QMovie movie = QMovie.movie;
    QScreening screening = QScreening.screening;
    QTheater theater = QTheater.theater;

    LocalDate today = LocalDate.now();

    return queryFactory
      .selectFrom(movie)
      .distinct()
      .join(movie.screenings, screening).fetchJoin()
      .join(screening.theater, theater).fetchJoin()
      .where(
        theater.id.eq(theaterId),
        screening.screeningDate.goe(today),
        movie.genre.eq(genre)
      )
      .orderBy(movie.releaseDate.desc())
      .fetch();
  }

  /**
   * 특정 기간에 상영되는 영화 조회
   */
  public List<Movie> findMoviesByScreeningDateRange(Long theaterId, LocalDate startDate, LocalDate endDate) {
    QMovie movie = QMovie.movie;
    QScreening screening = QScreening.screening;
    QTheater theater = QTheater.theater;

    return queryFactory
      .selectFrom(movie)
      .distinct()
      .join(movie.screenings, screening).fetchJoin()
      .join(screening.theater, theater).fetchJoin()
      .where(
        theater.id.eq(theaterId),
        screening.screeningDate.between(startDate, endDate)
      )
      .orderBy(movie.releaseDate.desc())
      .fetch();
  }
}
