package com.hanghae.module.persistence.entity;

import com.hanghae.module.common.audit.BaseEntity;
import com.hanghae.module.common.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "seat")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SeatEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "screening_id", nullable = false)
  private Long screening;

  @Column(nullable = false)
  private String seatNumber;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SeatStatus status;

  @Column(nullable = false)
  private BigDecimal price;
}

