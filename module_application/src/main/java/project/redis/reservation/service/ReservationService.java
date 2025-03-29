package project.redis.reservation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.redis.reservation.dto.ReservationSeatsRequestDto;
import project.redis.reservation.dto.ReservationSeatsResponseDto;
import project.redis.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final UserRepository userRepository;

    public ReservationSeatsResponseDto reservationSeats(ReservationSeatsRequestDto reservationSeatsRequestDto) {
        // TODO: dto의 입력 값 검증

        return null;
    }
}
