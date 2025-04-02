package com.redis.application.reservation.application.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ReservationResponseDto {
    private final String cinemaName;
    private final LocalTime startMovieTime;
    private final LocalTime endMovieTime;
    private final List<String> reservedSeats;
}
