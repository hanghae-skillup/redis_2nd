package com.movie.movieapplication.movie.service;

import com.movie.movieapplication.exception.ApplicationException;
import com.movie.movieapplication.exception.ErrorCode;
import com.movie.movieapplication.movie.domain.Schedule;
import com.movie.movieapplication.movie.domain.Screen;
import com.movie.movieapplication.movie.domain.Theater;
import com.movie.movieapplication.movie.domain.Movie;
import com.movie.movieapplication.movie.dto.*;
import com.movie.movieapplication.movie.repository.MovieRepository;
import com.movie.movieapplication.movie.repository.ScheduleRepository;
import com.movie.movieapplication.movie.repository.ScreenRepository;
import com.movie.movieapplication.movie.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScreenRepository screenRepository;
    private final TheaterRepository theaterRepository;
    private final MovieRepository movieRepository;

    public List<ScheduleInfo.Get> getSchedules(Long theaterId) {
        List<Schedule> schedules = scheduleRepository.getSchedules(theaterId);

        Map<Long, List<Schedule>> groupedByScreen = schedules.stream()
                .collect(Collectors.groupingBy(Schedule::getScreenId));

        return groupedByScreen.entrySet().stream().map(entry -> {
            Long screenId = entry.getKey();
            List<Schedule> schedulesForScreen = entry.getValue();
            Schedule firstSchedule = schedulesForScreen.get(0);

            Screen screen = screenRepository.findById(screenId)
                    .orElseThrow(() -> new ApplicationException(ErrorCode.CONTENT_NOT_FOUND));

            Theater theater = theaterRepository.findById(firstSchedule.getTheaterId())
                    .orElseThrow(() -> new ApplicationException(ErrorCode.CONTENT_NOT_FOUND));

            Movie movie = movieRepository.findById(firstSchedule.getMovieId())
                    .orElseThrow(() -> new ApplicationException(ErrorCode.CONTENT_NOT_FOUND));

            List<TimeTableInfo.Get> timeTables = schedulesForScreen.stream()
                    .map(schedule -> new TimeTableInfo.Get(schedule.getStartTime(), schedule.getEndTime()))
                    .toList();

            return new ScheduleInfo.Get(
                    firstSchedule.getId(),
                    new TheaterInfo.Get(theater.getId(), theater.getName()),
                    new ScreenInfo.Get(screen.getId(), screen.getTheaterId(), screen.getName()),
                    new MovieInfo.Get(
                            movie.getId(), movie.getTitle(),
                            movie.getReleasedAt(), movie.getThumbnailUrl(),
                            movie.getRunningTime(), movie.getRating(), movie.getGenre()
                    ),
                    timeTables
            );
        }).toList();
    }
}
