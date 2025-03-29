package project.redis.reservation.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ReservationSeatsRequestDto {
    private Long userId;
    private Long screeningId;
    private List<String> seatRows = new ArrayList<>();
    private List<Integer> seatColumns = new ArrayList<>();
}
