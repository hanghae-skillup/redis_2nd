package com.redis.domain.seat.repository;


import com.redis.domain.seat.entity.MovieSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieSeatRepository extends JpaRepository<MovieSeat,Long> {
    @Query("SELECT ms FROM MovieSeat ms WHERE ms.cinemaId = :cinemaId AND ms.seatId IN :seatIdList AND ms.isReserved = false")
    List<MovieSeat> findAvailableSeats(@Param("cinemaId") Long cinemaId, @Param("seatIdList") List<Long> seatIdList);


}