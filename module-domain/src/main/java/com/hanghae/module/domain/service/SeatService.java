package com.hanghae.module.domain.service;

import com.hanghae.module.domain.model.Screening;
import com.hanghae.module.domain.model.Seat;

import java.util.List;

public interface SeatService {

  List<Seat> getSeats(Long screeningId, List<String> seatNumbers);

  /**
   * 예약된 좌석 번호를 검증합니다.
   *
   * @param seats 예약된 좌석 번호 리스트
   * @param screening 상영 정보
   * @throws IllegalArgumentException 좌석 번호가 유효하지 않은 경우
   */
  void validateSeats(List<Seat> seats, Screening screening);

  void assignSeats(List<Seat> seats);
}
