package com.hanghae.theater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SeatColTest {
    
    @DisplayName("좌석의 열 값은 1~5 범위이며, 이 범위를 벗어나면 예외 발생한다")
    @ValueSource(ints = {0, 6})
    @ParameterizedTest
    void create(int col){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SeatCol(col));

    }
}
