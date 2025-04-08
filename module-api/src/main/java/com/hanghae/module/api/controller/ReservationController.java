package com.hanghae.module.api.controller;

import com.hanghae.module.api.dto.request.ReservationRequest;
import com.hanghae.module.api.dto.response.ReservationResponse;
import com.hanghae.module.core.facade.ReservationFacade;
import com.hanghae.module.domain.model.Reservation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

  private final ReservationFacade reservationFacade;

  @PostMapping
  public ResponseEntity<ReservationResponse> reserve(@Valid @RequestBody ReservationRequest request) {
    Reservation reservation = reservationFacade.reserve(request.getUserId(), request.getScreeningId(), request.getSeatNumbers());
    return ResponseEntity.status(HttpStatus.CREATED).body(ReservationResponse.from(reservation));
  }
}
