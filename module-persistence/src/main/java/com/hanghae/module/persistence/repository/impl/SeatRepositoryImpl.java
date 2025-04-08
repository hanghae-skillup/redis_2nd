package com.hanghae.module.persistence.repository.impl;

import com.hanghae.module.domain.model.Seat;
import com.hanghae.module.domain.repository.SeatRepository;
import com.hanghae.module.persistence.entity.SeatEntity;
import com.hanghae.module.persistence.mapper.SeatMapper;
import com.hanghae.module.persistence.repository.jpa.SeatJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SeatRepositoryImpl implements SeatRepository {
  private final SeatJpaRepository seatJpaRepository;
  private final SeatMapper seatMapper;

  @Override
  public List<Seat> getSeats(Long screening, List<String> seatNumbers) {
    List<SeatEntity> entities = seatJpaRepository.findByScreeningAndSeatNumberIn(screening, seatNumbers);
    return seatMapper.toDomainList(entities);
  }

  @Override
  public void saveAll(List<Seat> seats) {

  }
}
