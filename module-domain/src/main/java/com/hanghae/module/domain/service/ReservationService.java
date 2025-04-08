package com.hanghae.module.domain.service;

import com.hanghae.module.domain.model.Reservation;

public interface ReservationService {

  Reservation saveReservation(Reservation reservation);
//  Reservation reserve(Long userId, Long screeningId, List<String> seatNumbers);
}
