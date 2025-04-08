package com.hanghae.module.domain.repository;

import com.hanghae.module.domain.model.Seat;

import java.util.List;

public interface SeatRepository {
  List<Seat> getSeats(Long screening, List<String> seatNumbers);

  void saveAll(List<Seat> seats);
}
