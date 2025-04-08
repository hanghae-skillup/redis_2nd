package com.hanghae.module.domain.model;

import com.hanghae.module.common.enums.ReservationStatus;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
public record Reservation(
  Long id,
  Long user,
  Long screening,
  List<String> seatNumbers,
  ReservationStatus status,
  LocalDateTime createdAt
) {

  /**
   * 새로운 예약을 생성하는 정적 팩토리 메소드
   *
   * @param userId 사용자 ID
   * @param screeningId 상영 ID
   * @return 생성된 예약 객체
   */
  public static Reservation create(Long userId, Long screeningId, List<String> seatNumbers) {
    return Reservation.builder()
      .user(userId)
      .screening(screeningId)
      .seatNumbers(seatNumbers)
      .status(ReservationStatus.PENDING)
      .createdAt(LocalDateTime.now())
      .build();
  }

  public Reservation updateStatus(ReservationStatus status) {
    return Reservation.builder()
      .id(this.id)
      .user(this.user)
      .screening(this.screening)
      .seatNumbers(this.seatNumbers)
      .status(status)
      .createdAt(this.createdAt)
      .build();
  }
}
