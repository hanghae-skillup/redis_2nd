package org.bailey.repository;

import org.bailey.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovieRepository extends JpaRepository<Movie, Long> {
}
