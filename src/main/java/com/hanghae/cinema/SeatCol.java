package com.hanghae.cinema;

public class SeatCol {

    private static final int MIN_COL_SIZE = 1;
    private static final int MAX_COL_SIZE = 5;

    private final int col;

    public SeatCol(final int col) {
        if (col < MIN_COL_SIZE || col > MAX_COL_SIZE) {
            throw new IllegalArgumentException("좌석의 열은 1~5 사이의 값만 입력 가능합니다");
        }
        this.col = col;
    }

    public int getCol() {
        return col;
    }
}
