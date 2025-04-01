package com.hanghae.booking.dto;

import com.hanghae.booking.Booking;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BookScreeningResponse {

    private Long id;

    private Long memberId;

    private Long screeningId;

    private List<BookingSeatDto> bookingSeats;

    public BookScreeningResponse(Long id, Long memberId, Long screeningId, List<BookingSeatDto> bookingSeats) {
        this.id = id;
        this.memberId = memberId;
        this.screeningId = screeningId;
        this.bookingSeats = bookingSeats;
    }

    public static BookScreeningResponse from(Booking booking) {
        List<BookingSeatDto> bookingSeats = booking.getBookingSeats().getBookingSeats().stream()
                .map(BookingSeatDto::from)
                .toList();

        return new BookScreeningResponse(booking.getId(), booking.getMemberId(), booking.getScreeningId(), bookingSeats);
    }
}
