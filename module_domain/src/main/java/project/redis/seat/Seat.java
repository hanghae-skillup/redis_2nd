package project.redis.seat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Seat {

    public static final int ROWS = 5;
    public static final int COLUMNS = 5;

    private Long seatId;
    private String seatRow;
    private Integer seatColumn;

    public static Seat of(Long seatId, String seatRow, Integer seatColumn) {
        isRightRangeRow(seatRow);
        isRightRangeCol(seatColumn);
        return new Seat(seatId, seatRow, seatColumn);
    }

    public static Seat of(String seatRow, Integer seatColumn) {
        isRightRangeRow(seatRow);
        isRightRangeCol(seatColumn);
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

    private static void isRightRangeRow(String seatRow) {
        if (seatRow.charAt(0) - 'A' >= ROWS) {
            throw new IllegalArgumentException("행의 범위를 넘어선 좌석입니다.");
        }
    }

    private static void isRightRangeCol(Integer seatColumn) {
        if (seatColumn > COLUMNS) {
            throw new IllegalArgumentException("열의 범위를 넘어선 좌석입니다.");
        }
    }

}
