package com.hanghae.module.persistence.entity;

import com.hanghae.module.common.audit.BaseEntity;
import com.hanghae.module.domain.model.ReservationSeat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "reservation_seat")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationSeatEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "reservation_id", nullable = false)
  private Long reservation;

  @Column(name = "seat_id", nullable = false)
  private Long seat;

  @Column(nullable = false)
  private BigDecimal amount;

  public ReservationSeat toDomain() {
    return ReservationSeat.builder()
      .id(this.id)
      .reservation(this.reservation)
      .seat(this.seat)
      .amount(this.amount)
      .reservedAt(this.getCreatedAt())
      .build();
  }

  public static ReservationSeatEntity from(ReservationSeat domain) {
    if (domain == null) {
      return null;
    }

    return ReservationSeatEntity.builder()
      .id(domain.id())
      .reservation(domain.reservation())
      .seat(domain.seat())
      .amount(domain.amount())
      .build();
  }
}
