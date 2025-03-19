package com.hanghae.theater.dto;

import com.hanghae.theater.Screening;

import java.util.List;

public record ScreeningsAddRequest(
        Long theaterId,
        List<ScreeningDto> screenings
) {
    public static List<Screening> toScreenings(ScreeningsAddRequest request) {
        return request.screenings().stream()
                .map(item -> new Screening(item.movieId(), item.screenNumber(), item.screeningTime(), item.seatCount()))
                .toList();
    }
}
