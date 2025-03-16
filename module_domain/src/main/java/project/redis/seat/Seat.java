package project.redis.seat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Seat {
    private Boolean isReserved;
    private String seatRow;
    private Integer seatColumn;

    public static Seat of(Boolean isReserved, String seatRow, Integer seatColumn) {
        return new Seat(isReserved, seatRow, seatColumn);
    }
}
