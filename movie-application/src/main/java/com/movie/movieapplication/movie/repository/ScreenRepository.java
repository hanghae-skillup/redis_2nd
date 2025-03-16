package com.movie.movieapplication.movie.repository;

import com.movie.movieapplication.movie.domain.Screen;
import java.util.Optional;

public interface ScreenRepository {
    Optional<Screen> findById(Long id);
}
