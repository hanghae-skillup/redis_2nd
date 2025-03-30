package com.hanghae.booking;

import com.hanghae.common.entity.BaseEntity;
import com.hanghae.theater.Seats;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Booking extends BaseEntity {

    private static final int BOOKING_SEAT_LIMIT = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private Long screeningId;

    @Embedded
    private BookingSeats bookingSeats = new BookingSeats();

    protected Booking() {
    }

    public Booking(Long memberId, Long screeningId) {
        this(null, memberId, screeningId);
    }

    public Booking(Long id, Long memberId, Long screeningId) {
        this.id = id;
        this.memberId = memberId;
        this.screeningId = screeningId;
    }

    public void addBookSeats(List<BookingSeat> seats) {
        if (seats.size() > BOOKING_SEAT_LIMIT) {
            throw new IllegalArgumentException(String.format("%d석 이상 예약할 수 없습니다", BOOKING_SEAT_LIMIT));
        }
        bookingSeats.add(seats);
    }
}
