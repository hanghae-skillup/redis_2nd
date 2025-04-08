package com.hanghae.module.domain.service.impl;

import com.hanghae.module.domain.repository.ReservationRepository;
import com.hanghae.module.domain.service.ReservationService;
import com.hanghae.module.domain.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationServiceImpl implements ReservationService {
  private final ReservationRepository reservationRepository;

  @Override
  public Reservation saveReservation(Reservation reservation) {
    return reservationRepository.save(reservation);
  }
}
