package com.redis.domain.reservation.repository;

import com.redis.domain.reservation.entity.ReservationSeat;
import com.redis.domain.seat.entity.MovieSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationSeatRepository extends JpaRepository<ReservationSeat,Long> {

}
