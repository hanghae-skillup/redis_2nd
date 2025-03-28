package com.hanghae.theater;

import com.hanghae.common.entity.BaseEntity;
import jakarta.persistence.*;

@Entity
public class Seat extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Embedded
    private SeatCol col;

    @Embedded
    private SeatRow row;

    protected Seat() {
    }

    public Seat(int row, int col) {
        this(new SeatRow(row), new SeatCol(col));
    }

    public Seat(SeatRow row, SeatCol col) {
        this.row = row;
        this.col = col;
    }
}
