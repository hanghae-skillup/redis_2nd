package com.pepponechoi.cinema.reservation.controller;

import com.pepponechoi.cinema.reservation.dto.request.create.CreateReservationRequest;
import com.pepponechoi.cinema.reservation.dto.response.ReservationResponse;
import com.pepponechoi.cinema.reservation.service.ReservationService;
import java.net.URI;
import java.net.URISyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;

    @PostMapping
    public ResponseEntity<ReservationResponse> create(@RequestBody CreateReservationRequest request)
            throws URISyntaxException {
        ReservationResponse response = service.create(request);
        return ResponseEntity.created(new URI(String.valueOf(response.id()))).body(response);
    }
}
