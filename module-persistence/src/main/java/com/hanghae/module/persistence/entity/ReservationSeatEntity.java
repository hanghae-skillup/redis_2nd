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
}
