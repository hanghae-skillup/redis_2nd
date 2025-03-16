package com.movie.movieinfrastructures.repository;

import com.movie.movieapplication.movie.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface MovieJpaRepository extends CrudRepository<MovieEntity, Long> {



}
