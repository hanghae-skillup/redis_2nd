package com.hanghae.module.persistence.entity;

import com.hanghae.module.common.audit.BaseEntity;
import com.hanghae.module.common.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private Long user;

  @Column(name = "screening_id", nullable = false)
  private Long screening;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ReservationStatus status;
}
