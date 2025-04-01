package com.pepponechoi.cinema.movie.repository;

import com.pepponechoi.cinema.movie.entity.Movie;
import com.pepponechoi.cinema.movie.repository.querydsl.MovieQueryDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJpaRepository extends JpaRepository<Movie, Long>, MovieRepository, MovieQueryDslRepository {

}
