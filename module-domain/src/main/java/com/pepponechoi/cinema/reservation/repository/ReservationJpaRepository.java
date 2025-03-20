package com.pepponechoi.cinema.reservation.repository;

import com.pepponechoi.cinema.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpaRepository extends JpaRepository<Reservation, Long>, ReservationRepository {

}
