package com.app.movie.repository;

import com.app.movie.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreJpaRepository extends JpaRepository<GenreEntity, Long> {

}
