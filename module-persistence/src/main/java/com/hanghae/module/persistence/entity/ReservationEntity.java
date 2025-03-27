package com.hanghae.module.persistence.entity;

import com.hanghae.module.common.audit.BaseEntity;
import com.hanghae.module.common.enums.ReservationStatus;
import com.hanghae.module.domain.model.Reservation;
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

  /**
   * 예약 엔티티를 도메인 모델로 변환
   */
  public Reservation toDomain() {
    return Reservation.builder()
      .id(this.id)
      .user(this.user)
      .screening(this.screening)
      .status(this.status)
      .createdAt(this.getCreatedAt())
      .build();
  }

  /**
   * 예약 도메인 모델을 엔티티로 변환
   */
  public static ReservationEntity from(Reservation domain) {
    if (domain == null) {
      return null;
    }

    return ReservationEntity.builder()
      .id(domain.id())
      .user(domain.user())
      .screening(domain.screening())
      .status(domain.status())
      .build();
  }
}
