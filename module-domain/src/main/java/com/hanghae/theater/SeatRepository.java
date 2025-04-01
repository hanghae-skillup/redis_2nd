package com.hanghae.theater;

import java.util.List;

public interface SeatRepository {
    List<Seat> findByIdIn(List<Long> ids);
}
