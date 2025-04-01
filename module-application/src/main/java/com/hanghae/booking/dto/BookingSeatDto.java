package com.hanghae.booking.dto;

import com.hanghae.booking.BookingSeat;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookingSeatDto {
    private Long id;

    private Long seatId;

    public BookingSeatDto(Long id, Long seatId) {
        this.id = id;
        this.seatId = seatId;
    }

    public static BookingSeatDto from(BookingSeat bookingSeat) {
        return new BookingSeatDto(bookingSeat.getId(), bookingSeat.getSeatId());
    }
}
