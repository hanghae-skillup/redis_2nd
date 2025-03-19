package com.module.redis2nd.domain.movie.repository;

import com.module.redis2nd.domain.movie.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    @Query("SELECT s FROM Screening s JOIN FETCH Movie m ON m.id = s.movie.id JOIN FETCH ShowSchedule sc ON m.id = sc.movie.id ORDER BY m.releaseDate ASC, sc.startShowTime ASC")
    List<Screening> findAllOrderByReleaseDateAndStartTime();
}
