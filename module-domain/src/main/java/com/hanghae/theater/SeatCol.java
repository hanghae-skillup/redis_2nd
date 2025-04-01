package com.hanghae.theater;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@Embeddable
public class SeatCol {

    private static final int MIN_COL_SIZE = 1;
    private static final int MAX_COL_SIZE = 5;

    private int col;

    protected SeatCol() {}

    public SeatCol(final int col) {
        if (col < MIN_COL_SIZE || col > MAX_COL_SIZE) {
            throw new IllegalArgumentException("");
        }
        this.col = col;
    }
}
