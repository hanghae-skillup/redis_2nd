package com.hanghae.module.persistence.entity;

import com.hanghae.module.common.audit.BaseEntity;
import com.hanghae.module.domain.model.Screening;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "screening")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "movie_id", nullable = false)
  private Long movie;

  @Column(name = "theater_id", nullable = false)
  private Long theater;

  @Column(nullable = false)
  private LocalDateTime startTime;

  @Column(nullable = false)
  private LocalDateTime endTime;

  public Screening toDomain() {
    return Screening.builder()
      .id(this.id)
      .movie(this.movie)
      .theater(this.theater)
      .startTime(this.startTime)
      .endTime(this.endTime)
      .build();
  }

  public static ScreeningEntity from(Screening domain) {
    if (domain == null) {
      return null;
    }

    return ScreeningEntity.builder()
      .id(domain.id())
      .movie(domain.movie())
      .theater(domain.theater())
      .startTime(domain.startTime())
      .endTime(domain.endTime())
      .build();
  }
}
