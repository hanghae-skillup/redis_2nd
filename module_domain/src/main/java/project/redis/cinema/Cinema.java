package project.redis.cinema;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cinema {
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;

    private String cinemaName;
    private CinemaSeats cinemaSeats;

    public static Cinema of(String cinemaName) {
        return new Cinema(cinemaName, CinemaSeats.create());
    }
}
