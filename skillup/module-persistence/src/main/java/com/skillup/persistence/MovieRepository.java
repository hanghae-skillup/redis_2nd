package com.skillup.persistence;

import com.skillup.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m " +
           "JOIN FETCH m.schedules s " +
           "JOIN FETCH s.screen sc")
    List<Movie> findMoviesWithSchedulesAndScreens();
}
