package org.cinema_project.movieinfra.repository;

import org.cinema_project.moviedomain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
