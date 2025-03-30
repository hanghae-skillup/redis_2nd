package com.hanghae.booking.dto;

import com.hanghae.theater.Seat;
import com.hanghae.theater.SeatCol;
import com.hanghae.theater.SeatRow;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SeatDto {
    private Long seatId;
    private char row;
    private int col;

    public SeatDto(Long seatId, char row, int col) {
        this.seatId = seatId;
        this.row = row;
        this.col = col;
    }

    public Seat toSeat() {
        return new Seat(seatId, new SeatRow(row), new SeatCol(col));
    }
}
