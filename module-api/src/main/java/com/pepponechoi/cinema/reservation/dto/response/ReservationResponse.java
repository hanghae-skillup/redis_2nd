package com.pepponechoi.cinema.reservation.dto.response;

import com.pepponechoi.cinema.reservation.entity.Reservation;
import com.pepponechoi.cinema.schedule.entity.Schedule;
import com.pepponechoi.cinema.seat.entity.Seat;
import com.pepponechoi.cinema.user.entity.User;
import java.time.LocalDateTime;
import java.util.List;

public record ReservationResponse(
    Long id,
    NestedScheduleResponse schedule,
    List<NestedSeatResponse> seats,
    NestedUserResponse user
) {

    public static ReservationResponse of(Reservation reservation) {
        return new ReservationResponse(
            reservation.getId(),
            NestedScheduleResponse.of(reservation.getSchedule()),
                reservation.getSeats().stream().map(NestedSeatResponse::of).toList(),
                NestedUserResponse.of(reservation.getUser())
        );
    }

    public record NestedUserResponse(Long id, String email, String nickname) {
        public static NestedUserResponse of(User user) {
            return new NestedUserResponse(
                    user.getId(),
                    user.getEmail(),
                    user.getNickname()
            );
        }
    }

    public record NestedScheduleResponse(
        Long id,
        String movieTitle,
        LocalDateTime start,
        LocalDateTime end
    ) {
        public static NestedScheduleResponse of(Schedule schedule) {
            return new NestedScheduleResponse(
                schedule.getId(),
                schedule.getMovie().getTitle(),
                schedule.getStart(),
                schedule.getEnd()
            );
        }
    }

    private record NestedSeatResponse(
        Long id,
        Character row,
        Integer column
    ) {
        public static NestedSeatResponse of(Seat seat) {
            return new NestedSeatResponse(
                seat.getId(),
                seat.getRowNo(),
                seat.getColumnNo()
            );
        }
    }
}
