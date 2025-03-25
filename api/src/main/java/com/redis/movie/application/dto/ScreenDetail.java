package com.redis.movie.application.dto;

import java.util.List;

public record ScreenDetail(
        String theaterId,
        String theaterNm,
        List<ScreenTime> screeningTimes
) {}
