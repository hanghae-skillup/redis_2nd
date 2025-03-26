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
}
