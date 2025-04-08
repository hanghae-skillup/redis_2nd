package com.hanghae.module.common.enums;

public enum ReservationStatus {
  PENDING("대기중"),
  CONFIRMED("확정됨"),
  CANCELED("취소됨"),
  EXPIRED("만료됨");

  private final String description;

  ReservationStatus(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
