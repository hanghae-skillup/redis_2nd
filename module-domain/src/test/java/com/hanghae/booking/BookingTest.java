package com.hanghae.booking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BookingTest {

    @DisplayName("5 좌석 이상 예약할 수 없다")
    @Test
    void addSeats() {
        Booking booking = new Booking(1L, 1L);
        List<BookingSeat> bookingSeats = List.of(
                new BookingSeat(1L), new BookingSeat(2L), new BookingSeat(3L),
                new BookingSeat(4L), new BookingSeat(5L), new BookingSeat(6L)
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> booking.addBookSeats(bookingSeats));
    }
}
