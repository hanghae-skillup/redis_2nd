package com.hanghae.booking;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
public class BookingSeats {

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(
            name = "booking_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_booking_to_booking_seat")
    )
    private List<BookingSeat> bookingSeats = new ArrayList<>();

    protected BookingSeats() {
    }

    public BookingSeats(List<BookingSeat> bookingSeats) {
        this.bookingSeats = bookingSeats;
    }

    public void add(List<BookingSeat> seats) {
        for (BookingSeat seat : seats) {
            add(seat);
        }
    }

    public void add(BookingSeat seat) {
        bookingSeats.add(seat);
    }
}
