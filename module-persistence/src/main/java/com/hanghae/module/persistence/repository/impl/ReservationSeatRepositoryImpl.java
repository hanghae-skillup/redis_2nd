package com.hanghae.module.persistence.repository.impl;

import com.hanghae.module.domain.model.ReservationSeat;
import com.hanghae.module.domain.repository.ReservationSeatRepository;
import com.hanghae.module.persistence.entity.ReservationSeatEntity;
import com.hanghae.module.persistence.mapper.ReservationSeatMapper;
import com.hanghae.module.persistence.repository.jpa.ReservationSeatJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationSeatRepositoryImpl implements ReservationSeatRepository {
  private final ReservationSeatJpaRepository reservationSeatJpaRepository;
  private final ReservationSeatMapper reservationSeatMapper;

  @Override
  public void save(ReservationSeat reservationSeat) {
    reservationSeatJpaRepository.save(reservationSeatMapper.toEntity(reservationSeat));
  }


}
