package com.redis.application.reservation.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Getter
@AllArgsConstructor
public class ReservationRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long cinemaId;

    @NotNull
    private List<Long> seatIdList;
}
