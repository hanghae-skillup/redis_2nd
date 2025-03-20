package project.redis.movie;

import lombok.Getter;

@Getter
public enum MovieGenre {
    ACTION("액션"),
    ROMANCE("로맨스"),
    HORROR("호러"),
    SF("SF");

    private final String movieGenreDescription;

    MovieGenre(String movieGenreDescription) {
        this.movieGenreDescription = movieGenreDescription;
    }
}
