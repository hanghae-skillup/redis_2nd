package project.redis.reservation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.redis.reservation.dto.ReservationSeatsRequestDto;
import project.redis.reservation.dto.ReservationSeatsResponseDto;

@Service
@RequiredArgsConstructor
public class ReservationService {
    public ReservationSeatsResponseDto reservationSeats(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        return null;
    }
}
