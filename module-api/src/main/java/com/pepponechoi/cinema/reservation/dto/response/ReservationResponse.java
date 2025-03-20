package com.pepponechoi.cinema.reservation.dto.response;

import com.pepponechoi.cinema.reservation.entity.Reservation;
import com.pepponechoi.cinema.schedule.entity.Schedule;
import com.pepponechoi.cinema.seat.entity.Seat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ReservationResponse {
    private Long id;
    private NestedScheduleResponse schedule;
    private NestedSeatResponse seat;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.schedule = new NestedScheduleResponse(reservation.getSchedule());
        this.seat = new NestedSeatResponse(reservation.getSeat());
    }

    @Data
    private static class NestedScheduleResponse {
        private Long id;
        private String movieTitle;
        private LocalDateTime start;
        private LocalDateTime end;

        public NestedScheduleResponse(Schedule schedule) {
            this.id = schedule.getId();
            this.movieTitle = schedule.getMovie().getTitle();
            this.start = schedule.getStart();
            this.end = schedule.getEnd();
        }
    }

    @Data
    private static class NestedSeatResponse {
        private Long id;
        private Character row;
        private Integer column;

        public NestedSeatResponse(Seat seat) {
            this.id = seat.getId();
            this.row = seat.getRowNo();
            this.column = seat.getColumnNo();
        }
    }
}
