package com.pepponechoi.cinema.seat.repository;

import com.pepponechoi.cinema.seat.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatJpaRepository extends JpaRepository<Seat, Long>, SeatRepository {

}
