package com.hanghae.cinema;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class SeatRowTest {

    @DisplayName("좌석의 행을 A~E 사이의 영어 대문자를 입력하지 않으면 예외 발생한다")
    @ValueSource(chars = {'a', 'b', 'F'})
    @ParameterizedTest
    void create(char row){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SeatRow(row));
    }

}