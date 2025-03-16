package project.redis.cinema;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cinema {
    private String cinemaName;

    public static Cinema of(String cinemaName) {
        return new Cinema(cinemaName);
    }
}
