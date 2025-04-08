package com.hanghae.module.persistence.repository.jpa;

import com.hanghae.module.persistence.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatJpaRepository extends JpaRepository<SeatEntity, Long> {
  List<SeatEntity> findByScreeningAndSeatNumberIn(Long screeningId, List<String> seatNumbers);
}
