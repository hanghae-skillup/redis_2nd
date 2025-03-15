package com.cinema.application.port.out;

import com.cinema.application.dto.MovieScheduleProjection;

import java.util.List;

public interface MovieSchedulePort {

    List<MovieScheduleProjection> findNowPlayingMovies();
}
