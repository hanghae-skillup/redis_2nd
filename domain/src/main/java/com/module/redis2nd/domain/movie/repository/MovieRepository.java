package com.module.redis2nd.domain.movie.repository;

import com.module.redis2nd.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
