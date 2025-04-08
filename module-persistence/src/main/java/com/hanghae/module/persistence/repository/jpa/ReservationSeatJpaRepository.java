package com.hanghae.module.persistence.repository.jpa;

import com.hanghae.module.persistence.entity.ReservationSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationSeatJpaRepository extends JpaRepository<ReservationSeatEntity, Long> {

}
