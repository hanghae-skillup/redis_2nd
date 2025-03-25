package com.redis.movie.application.dto;

import java.time.LocalDateTime;

public record ScreenTime(
        LocalDateTime theaterMovieStartTm,
        LocalDateTime theaterMovieEndTm){}