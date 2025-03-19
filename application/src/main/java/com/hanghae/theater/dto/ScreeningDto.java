package com.hanghae.theater.dto;

import com.hanghae.theater.Screening;
import com.hanghae.theater.ScreeningTime;

import java.util.List;

public record ScreeningDto(
        Long movieId,
        int screenNumber,
        ScreeningTime screeningTime,
        int seatCount
) {

    public static List<Screening> toScreenings(List<ScreeningDto> screenings) {
        return screenings.stream()
                .map(screening -> new Screening(screening.movieId(), screening.screenNumber(), screening.screeningTime(), screening.seatCount()))
                .toList();
    }
}
