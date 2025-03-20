package com.hanghae.theater.dto;

import com.hanghae.theater.Screening;
import com.hanghae.theater.ScreeningTime;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public record ScreeningDto(
        @NotNull Long movieId,
        @Positive int screenNumber,
        @NotNull ScreeningTime screeningTime,
        @PositiveOrZero int seatCount
) {

    public static List<Screening> toScreenings(List<ScreeningDto> screenings) {
        return screenings.stream()
                .map(screening -> new Screening(screening.movieId(), screening.screenNumber(), screening.screeningTime(), screening.seatCount()))
                .toList();
    }
}
