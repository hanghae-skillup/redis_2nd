package project.redis.reservation.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationSeatsResponseDto {
    Long userId;
    List<Long> reservationsId;

    public static ReservationSeatsResponseDto of(Long userId, List<Long> reservationsId) {
        return ReservationSeatsResponseDto.builder()
                .userId(userId)
                .reservationsId(reservationsId)
                .build();
    }
}
