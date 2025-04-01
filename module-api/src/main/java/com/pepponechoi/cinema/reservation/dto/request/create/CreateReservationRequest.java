package com.pepponechoi.cinema.reservation.dto.request.create;

import java.util.List;

public record CreateReservationRequest(
        Long userId,
        List<NestedSeat> seats,
        Long scheduleId
) {
    public record NestedSeat(
            Character rowNo,
            Integer columnNo
    ) {

    }
}
