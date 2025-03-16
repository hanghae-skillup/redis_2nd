package com.app.movie.repository;

import com.app.movie.entity.ShowtimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ShowtimeJpaRepository extends JpaRepository<ShowtimeEntity, Long> {

    List<ShowtimeEntity> findByMovieId(Long movieId);
    List<ShowtimeEntity> findByMovie_ReleaseDateLessThanEqual(LocalDate date);

    @Query("SELECT s FROM ShowtimeEntity s " +
            "join fetch s.theater " +
            "left join fetch s.movie " +
            "left join fetch s.movie.genre " +
            "WHERE s.movie.releaseDate <= :today")
    List<ShowtimeEntity> findShowtime(@Param("today") LocalDate today);
}
