package com.hanghae.module.persistence.repository.impl;

import com.hanghae.module.domain.model.Reservation;
import com.hanghae.module.domain.repository.ReservationRepository;
import com.hanghae.module.persistence.entity.ReservationEntity;
import com.hanghae.module.persistence.mapper.ReservationMapper;
import com.hanghae.module.persistence.repository.jpa.ReservationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {
  private final ReservationJpaRepository reservationJpaRepository;
  private final ReservationMapper reservationMapper;

  @Override
  public Reservation save(Reservation reservation) {
     ReservationEntity entity = reservationJpaRepository.save(reservationMapper.toEntity(reservation));
     return reservationMapper.toDomain(entity);
  }
}
