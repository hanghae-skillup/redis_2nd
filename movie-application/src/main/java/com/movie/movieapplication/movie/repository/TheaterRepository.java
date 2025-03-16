package com.movie.movieapplication.movie.repository;

import com.movie.movieapplication.movie.domain.Theater;
import java.util.Optional;

public interface TheaterRepository {

    Optional<Theater> findById(Long id);
}
