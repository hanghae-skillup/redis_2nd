package com.module.redis2nd.domain.reservation.repository;

import com.module.redis2nd.domain.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
