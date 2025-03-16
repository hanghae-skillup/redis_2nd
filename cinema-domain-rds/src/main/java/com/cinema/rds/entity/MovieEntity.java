package com.cinema.rds.entity;

import java.time.LocalDateTime;

import com.cinema.core.movie.Genre;
import com.cinema.core.movie.Rating;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@Enumerated(EnumType.STRING)
	private Rating rating;

	private LocalDateTime releasedAt;

	private String posterUrl;

	private Integer runningTime;

	@Enumerated(EnumType.STRING)
	private Genre genre;

}
