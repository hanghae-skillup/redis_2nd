package project.redis.reservation.adapter;

import java.util.List;
import project.redis.reservation.Reservation;

public interface ReservationAdapter {
    List<Reservation> findAllReservationByScreeningId(Long screeningId);

    Long saveReservation(Reservation reservation);
}
