package com.redis.application.reservation.application.convert;


import com.redis.application.reservation.application.dto.ReservationResponseDto;
import com.redis.domain.screen.entity.Screen;
import com.redis.domain.seat.entity.MovieSeat;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationReservationDtoMapper {

    public static ReservationResponseDto toServiceReservationResponseDto(List<MovieSeat> seats, Screen screen){

        List<String> reservedSeats = seats.stream()
                .map(seat -> seat.getSeatRow() + seat.getSeatCol())
                .collect(Collectors.toList());

        return new ReservationResponseDto(
                screen.getCinemaNm(),
                screen.getMovieStartTime().toLocalTime(),
                screen.getMovieEndTime().toLocalTime(),
                reservedSeats);

    }
}

