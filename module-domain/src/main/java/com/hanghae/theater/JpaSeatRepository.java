package com.hanghae.theater;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSeatRepository extends SeatRepository, JpaRepository<Seat, Long> {
}
