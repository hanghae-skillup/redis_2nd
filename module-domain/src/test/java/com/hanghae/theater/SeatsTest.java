package com.hanghae.theater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SeatsTest {

    @DisplayName("좌석의 수를 구한다")
    @Test
    void count() {
        Seats seats = new Seats(
                List.of(
                        new Seat(1, 1), new Seat(1, 2), new Seat(1, 3)
                )
        );

        assertThat(seats.count()).isEqualTo(3);
    }

    @DisplayName("좌석들이 다른 행이 있는지 확인한다")
    @Test
    void isDifferentRow(){
        Seats seats = new Seats(
                List.of(
                        new Seat('A', 1),
                        new Seat('B', 1)
                )
        );

        boolean result = seats.isDifferentRow();

        assertThat(result).isTrue();
    }

    @DisplayName("모든 좌석들이 같은 행인지 확인한다")
    @Test
    void isSameRow(){
        Seats seats = new Seats(
                List.of(
                        new Seat('A', 1),
                        new Seat('A', 2)
                )
        );

        boolean result = seats.isSameRow();

        assertThat(result).isTrue();
    }
}
