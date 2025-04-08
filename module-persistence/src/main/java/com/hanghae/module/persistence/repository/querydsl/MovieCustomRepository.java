package com.hanghae.module.persistence.repository.querydsl;

import com.hanghae.module.common.dto.MovieDTO;
import com.hanghae.module.common.dto.ScreeningDTO;
import com.hanghae.module.common.enums.Genre;
import com.hanghae.module.persistence.entity.QMovieEntity;
import com.hanghae.module.persistence.entity.QScreeningEntity;
import com.hanghae.module.persistence.entity.QTheaterEntity;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovieCustomRepository {

  private final JPAQueryFactory queryFactory;

  /**
   * 상영 중인 영화를 개봉일 기준으로 정렬하여 조회
   */
  public List<MovieDTO> findAllNowPlayingMovies(Long theaterId, String title, Genre genre) {
    QMovieEntity movie = QMovieEntity.movieEntity;
    QScreeningEntity screening = QScreeningEntity.screeningEntity;
    QTheaterEntity theater = QTheaterEntity.theaterEntity;

    LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);

    // 영화와 상영 정보를 조인하고, 특정 극장 ID로 필터링 (선택적)
    List<MovieDTO> movies = queryFactory
      .from(movie)
      .join(screening).on(screening.movie.eq(movie.id))
      .join(theater).on(screening.theater.eq(theater.id))
      .where(
        // 현재 상영 중인 영화 조건
        screening.startTime.goe(now).and(screening.startTime.lt(now.plusWeeks(2))),
        eqTheaterId(screening, theaterId),
        eqTitle(movie, title),
        eqGenre(movie, genre)
      )
      .orderBy(movie.releaseDate.desc())
      .transform(GroupBy.groupBy(movie.id)
        .list(Projections.constructor(MovieDTO.class,
          movie.id,
          movie.title,
          movie.rating,
          movie.releaseDate,
          movie.thumbnailUrl,
          movie.runningTime,
          movie.genre,
          GroupBy.list(Projections.constructor(ScreeningDTO.class,
              theater.id,
              theater.name,
              screening.startTime,
              screening.endTime
            ))
        ))
      );

    return movies.stream()
      .map(m -> {
        // 상영 정보 리스트를 정렬
        List<ScreeningDTO> sortedScreenings = m.getScreenings().stream()
          .sorted(Comparator.comparing(ScreeningDTO::getStartTime))
          .collect(Collectors.toList());

        // 새로운 MovieDTO 생성
        return MovieDTO.builder()
          .movieId(m.getMovieId())
          .title(m.getTitle())
          .rating(m.getRating())
          .releaseDate(m.getReleaseDate())
          .thumbnailUrl(m.getThumbnailUrl())
          .runningTime(m.getRunningTime())
          .genre(m.getGenre())
          .screenings(sortedScreenings)
          .build();
      })
//      .sorted(Comparator.comparing(MovieDTO::getReleaseDate).reversed()) // 개봉일 기준 내림차순 정렬
      .collect(Collectors.toList());
  }

  /**
   * theaterId 조건을 동적으로 처리하는 메소드
   */
  private BooleanExpression eqTheaterId(QScreeningEntity screening, Long theaterId) {
    return theaterId != null ? screening.theater.eq(theaterId) : null;
  }

  /**
   * 영화 제목 조건을 동적으로 처리하는 메소드
   * 요구사항에 맞게 동등 연산자(=)를 사용
   */
  private BooleanExpression eqTitle(QMovieEntity movie, String title) {
    return StringUtils.hasText(title) ? movie.title.eq(title) : null;
  }

  /**
   * 장르 조건을 동적으로 처리하는 메소드
   */
  private BooleanExpression eqGenre(QMovieEntity movie, Genre genre) {
    return genre != null ? movie.genre.eq(genre) : null;
  }
}
