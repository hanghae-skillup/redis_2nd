package project.redis.cinema;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import project.redis.seat.Seat;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cinema {
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;

    private String cinemaName;
    private List<List<Seat>> seats;

    public static Cinema of(String cinemaName) {
        List<List<Seat>> seats = createSeats();
        return new Cinema(cinemaName, seats);
    }

    private static List<List<Seat>> createSeats() {
        List<List<Seat>> seats = new ArrayList<>();
        for (int row = 0; row < ROWS; row++) {
            List<Seat> seat = new ArrayList<>();
            for (int col = 0; col < COLUMNS; col++) {
                Seat oneSeat = createOneSeat(row, col);
                seat.add(oneSeat);
            }
            seats.add(seat);
        }
        return seats;
    }

    private static Seat createOneSeat(int row, int col) {
        String seatRow = getSeatRow(row);
        Integer setColumn = col + 1;
        return Seat.of(false, seatRow, setColumn);
    }

    private static String getSeatRow(int rowNumber) {
        return String.valueOf((char) ('A' + rowNumber));
    }
}
