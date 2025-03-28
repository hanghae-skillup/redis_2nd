package com.hanghae.theater;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class ScreeningTest {

    @DisplayName("상영에 좌석을 생성한다")
    @Test
    void createSeats(){
        Screening screening = new Screening(
                1L,
                1,
                new ScreeningTime(
                        LocalDateTime.of(2025, 3, 14, 8, 0),
                        LocalDateTime.of(2025, 3, 14, 10, 0)
                )
        );

        int rowSize = 5;
        int colSize = 5;
        screening.createSeats(Seats.create(rowSize,colSize));

        assertThat(screening.getSeatCount()).isEqualTo(25);
        assertThat(screening.getSeats().count()).isEqualTo(25);
    }
    
    @DisplayName("좌석의 수를 감소한다")
    @Test
    void decreaseSeatCount() {
        //given
        Screening screening = new Screening(
                1L,
                1,
                new ScreeningTime(
                        LocalDateTime.of(2025, 3, 14, 8, 0),
                        LocalDateTime.of(2025, 3, 14, 10, 0)
                )
        );
        int rowSize = 5;
        int colSize = 5;
        screening.createSeats(Seats.create(rowSize,colSize));

        //when
        screening.decreaseSeatCount();

        assertThat(screening.getSeatCount()).isEqualTo(24);
    }

    @DisplayName("좌석의 수가 0개일 때, 좌석의 수를 감소하면 예외 발생한다")
    @Test
    void decreaseSeatCountByNegativeCount() {
        Screening screening = new Screening(
                1L,
                1,
                new ScreeningTime(
                        LocalDateTime.of(2025, 3, 14, 8, 0),
                        LocalDateTime.of(2025, 3, 14, 10, 0)
                )
        );

        assertThatIllegalStateException()
                .isThrownBy(screening::decreaseSeatCount);
    }
}
