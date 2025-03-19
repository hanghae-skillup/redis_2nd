package com.module.redis2nd.domain.movie.repository;

import com.module.redis2nd.domain.movie.entity.ShowSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowScheduleRepository extends JpaRepository<ShowSchedule, Long> {
}
