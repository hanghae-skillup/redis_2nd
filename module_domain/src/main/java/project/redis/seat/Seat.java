package project.redis.seat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Seat {

    private Long seatId;
    private String seatRow;
    private Integer seatColumn;

    public static Seat of(Long seatId, String seatRow, Integer seatColumn) {
        return new Seat(seatId, seatRow, seatColumn);
    }

    public static Seat of(String seatRow, Integer seatColumn) {
        return new Seat(null, seatRow, seatColumn);
    }

    public int compareRow(Seat otherSeat) {
        return this.seatRow.compareTo(otherSeat.seatRow);
    }

    public int compareCol(Seat otherSeat) {
        return Integer.compare(this.seatColumn, otherSeat.seatColumn);
    }

    public Boolean isThisSeat(String seatRow, Integer seatColumn) {
        return this.seatRow.equals(seatRow) && this.seatColumn.equals(seatColumn);
    }

}
