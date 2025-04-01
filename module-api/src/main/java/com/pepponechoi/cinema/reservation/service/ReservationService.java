package com.pepponechoi.cinema.reservation.service;

import com.pepponechoi.cinema.reservation.dto.request.create.CreateReservationRequest;
import com.pepponechoi.cinema.reservation.dto.response.ReservationResponse;

public interface ReservationService {
    ReservationResponse create(CreateReservationRequest request);
}
