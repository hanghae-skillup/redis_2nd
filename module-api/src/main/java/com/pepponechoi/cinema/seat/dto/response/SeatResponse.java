package com.pepponechoi.cinema.seat.dto.response;

import com.pepponechoi.cinema.screen.entity.Screen;
import com.pepponechoi.cinema.seat.entity.Seat;
import lombok.Data;

@Data
public class SeatResponse {
    private Long id;
    private Character row;
    private Integer column;
    private NestedScreenResponse screen;

    public SeatResponse(Seat seat) {
        this.id = seat.getId();
        this.row = seat.getRowNo();
        this.column = seat.getColumnNo();
        this.screen = new NestedScreenResponse(seat.getScreen());
    }

    @Data
    private static class NestedScreenResponse {
        private Long id;
        private String name;

        public NestedScreenResponse(Screen screen) {
            this.id = screen.getId();
            this.name = screen.getName();
        }
    }
}

