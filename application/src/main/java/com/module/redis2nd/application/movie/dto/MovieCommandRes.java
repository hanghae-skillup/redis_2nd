package com.module.redis2nd.application.movie.dto;

import com.module.redis2nd.domain.common.enums.GenreType;
import com.module.redis2nd.domain.movie.entity.Movie;
import com.module.redis2nd.domain.movie.entity.Screening;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class MovieCommandRes {
    @Getter
    public static class ScreeningMovies {
        private List<ScreeningMovie> screeningMovies;

        public ScreeningMovies(List<Screening> screenings) {
            this.screeningMovies = screenings
                                    .stream()
                                    .map(s -> new ScreeningMovie(s.getMovie()))
                                    .collect(Collectors.toList());
        }
    }
    @Getter
    public static class ScreeningMovie {
        private Long movieId;
        private String title;
        private String thumbnail;
        private int movieRatings;
        private LocalDate releaseDate;
        private int runningTime;
        private String theaterName;
        private GenreType genre;
        private List<ShowScheduleInfo> showScheduleInfos;

        public ScreeningMovie(Movie movie) {
            this.movieId = movie.getId();
            this.title = movie.getTitle();
            this.thumbnail = movie.getThumbnail();
            this.movieRatings = movie.getMovieRatings();
            this.releaseDate = movie.getReleaseDate();
            this.runningTime = movie.getRunningTime();
            this.theaterName = movie.getTheaterName();
            this.genre = movie.getGenre();
            this.showScheduleInfos = movie.getShowSchedules()
                                                .stream()
                                                .map(s -> new ShowScheduleInfo(s.getStartShowTime(), movie.getRunningTime()))
                                                .collect(Collectors.toList());
        }
    }
    @Getter
    public static class ShowScheduleInfo {
        private LocalTime startShowTime;
        private LocalTime endShowTime;

        public ShowScheduleInfo(LocalTime startShowTime, int runningTime) {
            this.startShowTime = startShowTime;
            this.endShowTime =  calculateEndShowTime(startShowTime, runningTime);
        }
        private LocalTime calculateEndShowTime(LocalTime startShowTime, int runningTime) {
            return startShowTime.plusMinutes((long)Math.ceil(runningTime));
        }
    }
}
