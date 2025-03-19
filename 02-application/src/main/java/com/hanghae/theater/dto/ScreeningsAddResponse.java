package com.hanghae.theater.dto;

import com.hanghae.theater.Screening;
import com.hanghae.theater.Theater;

import java.util.List;

public record ScreeningsAddResponse(
        Long theaterId,
        String name,
        List<Screening> screenings
) {
    public static ScreeningsAddResponse from(Theater theater) {
        return new ScreeningsAddResponse(
                theater.getId(),
                theater.getName(),
                theater.getScreenings()
        );
    }
}
