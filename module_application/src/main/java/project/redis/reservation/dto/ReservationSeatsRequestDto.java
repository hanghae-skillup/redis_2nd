package project.redis.reservation.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationSeatsRequestDto {
    private Long userId;
    private Long screeningId;
    private List<String> seatRows = new ArrayList<>();
    private List<Integer> seatColumns = new ArrayList<>();

    public static ReservationSeatsRequestDto of(Long userId, Long screeningId,
                                                List<String> seatRows, List<Integer> seatColumns) {
        return new ReservationSeatsRequestDto(userId, screeningId, seatRows, seatColumns);
    }
}
