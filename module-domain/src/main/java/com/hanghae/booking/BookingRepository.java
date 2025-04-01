package com.hanghae.booking;

import java.util.List;

public interface BookingRepository {
    Booking save(Booking booking);

    List<Booking> findByScreeningId(Long screeningId);
}
