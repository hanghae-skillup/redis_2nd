package project.redis.screening.adapter;

import java.util.List;
import project.redis.movie.Movie;
import project.redis.screening.Screening;

public interface ScreeningAdapter {
    List<Screening> findScreenings(Movie movie);

    Screening findScreening(Long screeningId);
}
