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

}