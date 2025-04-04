package project.redis.seat.adapter;

import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;

public interface SeatAdapter {
    SeatEntity save(Seat seat);
}
