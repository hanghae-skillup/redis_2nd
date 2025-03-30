package com.hanghae.theater;

import com.hanghae.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
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

    public Seat(char row, int col) {
        this(null, new SeatRow(row), new SeatCol(col));
    }

    public Seat(int row, int col) {
        this(null, new SeatRow(row), new SeatCol(col));
    }

    public Seat(Long id, SeatRow row, SeatCol col) {
        this.id = id;
        this.row = row;
        this.col = col;
    }
}
