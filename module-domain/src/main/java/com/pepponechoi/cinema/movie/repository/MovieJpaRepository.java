package com.pepponechoi.cinema.movie.repository;

import com.pepponechoi.cinema.movie.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieJpaRepository extends JpaRepository<Movie, Long>, MovieRepository {
    @Query("SELECT m, s FROM Movie m LEFT JOIN Schedule s ON s.movie.id = m.id LEFT JOIN FETCH s.screen")
    List<Object[]> findAllWithSchedule();
}
