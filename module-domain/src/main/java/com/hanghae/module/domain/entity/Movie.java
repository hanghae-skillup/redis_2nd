package com.hanghae.module.domain.entity;

import com.hanghae.module.domain.enums.Genre;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {
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

  @OneToMany(mappedBy = "movie")
  private List<Screening> screenings = new ArrayList<>();
}
