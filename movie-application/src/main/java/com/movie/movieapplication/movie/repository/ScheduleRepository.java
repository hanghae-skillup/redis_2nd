package com.movie.movieapplication.movie.repository;

import com.movie.movieapplication.movie.domain.Schedule;

import java.util.List;

public interface ScheduleRepository {

    List<Schedule> getSchedules(Long theaterId);

}
