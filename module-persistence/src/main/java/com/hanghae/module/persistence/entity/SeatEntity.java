package com.hanghae.module.persistence.entity;

import com.hanghae.module.common.audit.BaseEntity;
import com.hanghae.module.domain.model.Seat;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(nullable = false)
    private BigDecimal amount;

    public Seat toDomain() {
        return Seat.builder()
          .id(this.id)
          .screening(this.screening)
          .seatNumber(this.seatNumber)
          .amount(this.amount)
          .build();
    }

    public static SeatEntity from(Seat domain) {
        if (domain == null) {
            return null;
        }

        return SeatEntity.builder()
          .id(domain.id())
          .screening(domain.screening())
          .seatNumber(domain.seatNumber())
          .amount(domain.amount())
          .build();
    }
}
