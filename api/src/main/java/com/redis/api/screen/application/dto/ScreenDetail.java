package com.redis.api.screen.application.dto;

import java.util.List;

public record ScreenDetail(
        Long cinemaId,
        String cinemaNm,
        List<ScreenTime> screeningTimes
) {}
