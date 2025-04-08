package com.hanghae.module.domain.service.impl;

import com.hanghae.module.domain.model.ReservationSeat;
import com.hanghae.module.domain.model.Screening;
import com.hanghae.module.domain.repository.ReservationSeatRepository;
import com.hanghae.module.domain.service.ReservationSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationSeatServiceImpl implements ReservationSeatService {
  private final ReservationSeatRepository reservationSeatRepository;

  @Override
  public void saveReservationSeat(ReservationSeat reservationSeat) {
    reservationSeatRepository.save(reservationSeat);
  }
}
