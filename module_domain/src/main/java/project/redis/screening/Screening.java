package project.redis.screening;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import project.redis.Movie.Movie;
import project.redis.cinema.Cinema;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Screening {
    private Movie movie;
    private Cinema cinema;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static Screening of(Movie movie, Cinema cinema, LocalDateTime startTime, LocalDateTime endTime) {
        return new Screening(movie, cinema, startTime, endTime);
    }
}
