package com.hanghae.module.domain.service.impl;

import com.hanghae.module.domain.model.Screening;
import com.hanghae.module.domain.model.Seat;
import com.hanghae.module.domain.repository.SeatRepository;
import com.hanghae.module.domain.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeatServiceImpl implements SeatService {
  private final SeatRepository seatRepository;

  @Override
  public void validateSeats(List<Seat> seats, Screening screening) {
    // 1. 좌석 수 검증 (최대 5개)
    if (seats.size() > 5) {
      throw new IllegalArgumentException("최대 5개까지 좌석 예약이 가능합니다.");
    }

    // 2. 좌석 형식 검증 (A1, B3 등)
    for (Seat seat : seats) {
      String seatNumber = seat.seatNumber();
      if (!isValidSeatFormat(seatNumber)) {
        throw new IllegalArgumentException("잘못된 좌석 형식입니다: " + seatNumber);
      }
    }

    // 3. 인접 좌석 검증 (같은 열에 있고 연속된 번호인지)
    validateAdjacentSeats(seats);

    // 4. 예약 가능 여부 검증
    for (Seat seat : seats) {
      if (seat.isReserved()) {
        throw new IllegalArgumentException("이미 예약된 좌석입니다: " + seat.seatNumber());
      }
    }
  }

  @Override
  public void assignSeats(List<Seat> seats) {
    // 좌석 예약 처리
    List<Seat> updatedSeats = seats.stream()
      .map(Seat::assign)
      .toList();

    seatRepository.saveAll(updatedSeats);
  }

  @Override
  public List<Seat> getSeats(Long screeningId, List<String> seatNumbers) {
    return seatRepository.getSeats(screeningId, seatNumbers);
  }

  private boolean isValidSeatFormat(String seatNumber) {
    // 좌석 형식 검증 (A1, B3 등)
    return seatNumber.matches("[A-E][1-5]");
  }

  private void validateAdjacentSeats(List<Seat> seats) {
    if (seats.isEmpty()) {
      return;
    }

    // 모든 좌석이 같은 열에 있는지 확인
    char row = seats.getFirst().seatNumber().charAt(0);
    for (Seat seat : seats) {
      String seatNumber = seat.seatNumber();
      if (seatNumber.charAt(0) != row) {
        throw new IllegalArgumentException("모든 좌석은 같은 열에 있어야 합니다.");
      }
    }

    // 좌석 번호 추출하고 정렬
    List<Integer> columns = seats.stream()
      .map(seat -> Integer.parseInt(seat.seatNumber().substring(1)))
      .sorted()
      .toList();

    // 연속된 번호인지 확인
    for (int i = 0; i < columns.size() - 1; i++) {
      if (columns.get(i + 1) - columns.get(i) != 1) {
        throw new IllegalArgumentException("좌석은 연속되어야 합니다.");
      }
    }
  }
}
