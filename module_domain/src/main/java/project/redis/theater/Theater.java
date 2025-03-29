package project.redis.theater;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import project.redis.cinema.Cinema;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Theater {
    private Long theaterId;
    @Getter
    private String theaterName;
    private Cinema cinema;

    public static Theater of(Long theaterId, String theaterName, Cinema cinema) {
        return new Theater(theaterId, theaterName, cinema);
    }

    public String getCinemaNameOfTheater() {
        return cinema.getCinemaName();
    }
}
