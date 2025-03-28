package com.hanghae.theater;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@Embeddable
public class SeatRow {

    private static final int ROW_SIZE = 5;
    private static final char START_ROW = 'A';

    private char rowCode;

    public SeatRow(final int rowCode) {
        this(toChar(rowCode));
    }

    private static char toChar(int row) {
        return (char) (START_ROW + row - 1);
    }

    protected SeatRow() {
    }

    public SeatRow(final char rowCode) {
        validate(rowCode);
        this.rowCode = rowCode;
    }

    private void validate(char row) {
        char endRow = toChar(ROW_SIZE);
        if (START_ROW > row || row > endRow) {
            throw new IllegalArgumentException("");
        }
    }

}
