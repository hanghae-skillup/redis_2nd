package project.redis.cinema;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cinema {
    private String cinemaName;
    private CinemaSeats cinemaSeats;

    public static Cinema of(String cinemaName) {
        return new Cinema(cinemaName, CinemaSeats.create());
    }
}
