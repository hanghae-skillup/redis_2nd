package org.bailey.domain.repository;

import org.bailey.domain.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    List<Movie> findAll();
    Optional<Movie> findById(Long id);
}