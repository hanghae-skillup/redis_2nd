package com.hanghae.booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookingRepository extends BookingRepository, JpaRepository<Booking, Long> {
}
