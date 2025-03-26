package com.hanghae.module.persistence.entity;

import com.hanghae.module.common.audit.BaseEntity;
import com.hanghae.module.common.enums.Genre;
import com.hanghae.module.domain.model.Movie;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "movie"
//  ,
//  indexes = {
//    @Index(name = "idx_movie_title", columnList = "title"),
//    @Index(name = "idx_movie_genre", columnList = "genre"),
//    @Index(name = "idx_movie_release_date", columnList = "releaseDate DESC")
//  }
  )
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String rating;

  @Column(nullable = false)
  private LocalDate releaseDate;

  @Column(nullable = false)
  private String thumbnailUrl;

  @Column(nullable = false)
  private Integer runningTime;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Genre genre;

  /**
   * 영화 엔티티를 도메인 모델로 변환
   */
  public Movie toDomain() {

    return Movie.builder()
      .id(this.id)
      .title(this.title)
      .rating(this.rating)
      .releaseDate(this.releaseDate)
      .thumbnailUrl(this.thumbnailUrl)
      .runningTime(this.runningTime)
      .genre(this.genre)
      .build();
  }

  /**
   * 영화 도메인 모델을 엔티티로 변환
   */
  public static MovieEntity from(Movie domain) {
    if (domain == null) {
      return null;
    }

    return MovieEntity.builder()
      .id(domain.id())
      .title(domain.title())
      .rating(domain.rating())
      .releaseDate(domain.releaseDate())
      .thumbnailUrl(domain.thumbnailUrl())
      .runningTime(domain.runningTime())
      .genre(domain.genre())
      .build();
  }
}
