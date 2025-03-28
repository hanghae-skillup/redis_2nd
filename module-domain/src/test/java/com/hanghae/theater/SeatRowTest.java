package com.hanghae.theater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SeatRowTest {

    @DisplayName("좌석의 행은 대문자 A~E 범위의 값이며, 이 범위가 아닌 값은 예외 발생한다")
    @ValueSource(chars = {'F', 'a', '★'})
    @ParameterizedTest
    void create(char row) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SeatRow(row));
    }

    @DisplayName("숫자로 생성된 좌석의 행과 문자로 생성된 좌석의 행은 동일하다")
    @CsvSource({
            "1, A",
            "2, B",
            "3, C",
            "4, D",
            "5, E"
    })
    @ParameterizedTest
    void createByRowNumber(int rowOrder, char row) {
        assertThat(new SeatRow(rowOrder)).isEqualTo(new SeatRow(row));
    }
}
