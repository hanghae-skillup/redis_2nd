package project.redis.movie;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie {
    private String movieName;
    private MovieRate movieRate;
    private LocalDateTime movieReleaseDate;
    private String movieThumbnailImage;
    private Integer movieRunningTime;
    private MovieGenre movieGenre;

    public static Movie of(String movieName, MovieRate movieRate, LocalDateTime movieReleaseDate,
                           String movieThumbnailImage, Integer movieRunningTime, MovieGenre movieGenre) {
        return new Movie(movieName, movieRate, movieReleaseDate, movieThumbnailImage, movieRunningTime, movieGenre);
    }

    public boolean isReleasedBefore(LocalDateTime date) {
        return movieReleaseDate.isBefore(date);
    }

    public int compareReleaseDate(Movie movieToCompare) {
        return movieToCompare.movieReleaseDate.compareTo(this.movieReleaseDate);
    }
}
