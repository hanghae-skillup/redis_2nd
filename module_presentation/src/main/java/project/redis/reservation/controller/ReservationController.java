package project.redis.reservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.redis.reservation.dto.ReservationSeatsRequestDto;
import project.redis.reservation.dto.ReservationSeatsResponseDto;
import project.redis.reservation.service.ReservationService;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/seats")
    public ResponseEntity<ReservationSeatsResponseDto> reservationSeats(
            @RequestBody ReservationSeatsRequestDto reservationSeatsRequestDto) {
        ReservationSeatsResponseDto reservationSeatsResponseDto
                = reservationService.reservationSeats(reservationSeatsRequestDto);
        return ResponseEntity.ok(reservationSeatsResponseDto);
    }
}
