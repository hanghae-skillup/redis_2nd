package com.hanghae.theater.dto;

import com.hanghae.theater.Screening;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ScreeningsAddRequest(
        @NotNull Long theaterId,
        @NotEmpty List<ScreeningDto> screenings
) {
    public static List<Screening> toScreenings(ScreeningsAddRequest request) {
        return request.screenings().stream()
                .map(item -> new Screening(item.movieId(), item.screenNumber(), item.screeningTime(), item.seatCount()))
                .toList();
    }
}
