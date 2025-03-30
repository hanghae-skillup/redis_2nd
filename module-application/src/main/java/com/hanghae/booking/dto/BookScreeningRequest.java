package com.hanghae.booking.dto;

import com.hanghae.booking.Booking;
import com.hanghae.booking.BookingSeat;
import com.hanghae.theater.Seat;
import com.hanghae.theater.Seats;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class BookScreeningRequest {

    private Long memberId;

    private Long screeningId;

    private List<SeatDto> bookingSeats;

    public BookScreeningRequest(Long memberId, Long screeningId, List<SeatDto> bookingSeats) {
        this.memberId = memberId;
        this.screeningId = screeningId;
        this.bookingSeats = bookingSeats;
    }

    public Seats toSeats() {
        List<Seat> seats = bookingSeats.stream()
                .map(SeatDto::toSeat)
                .toList();
        return new Seats(seats);
    }

    public List<BookingSeat> toBookingSeats() {
        return bookingSeats.stream()
                .map(seat -> new BookingSeat(seat.getSeatId()))
                .toList();
    }

    public Booking toBooking() {
        return new Booking(memberId, screeningId);
    }
}

