package com.hanghae.module.domain.repository;

import com.hanghae.module.domain.model.Reservation;

public interface ReservationRepository {
  Reservation save(Reservation reservation);
}
