package com.hanghae.cinema;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeatsTest {

    @DisplayName("좌석의 행, 열 크기를 입력하여 좌석을 생성한다")
    @Test
    void create() {
        Seats seats = Seats.create(5, 5);

        int seatSize = seats.size();

        assertThat(seatSize).isEqualTo(25);
    }
}
