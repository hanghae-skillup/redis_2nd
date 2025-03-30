package com.hanghae.booking;

import com.hanghae.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class BookingSeat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long seatId;

    protected BookingSeat() {
    }

    public BookingSeat(Long seatId) {
        this(null, seatId);
    }

    public BookingSeat(Long id, Long seatId) {
        this.id = id;
        this.seatId = seatId;
    }


}
