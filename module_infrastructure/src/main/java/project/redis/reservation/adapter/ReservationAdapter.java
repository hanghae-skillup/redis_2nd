package project.redis.reservation.adapter;

import java.util.List;
import project.redis.reservation.Reservation;

public interface ReservationAdapter {
    List<Reservation> findAllReservationByScreeningId(Long screeningId);

    List<Reservation> findAllReservationByUserId(Long userId);

    Long saveReservation(Reservation reservation);
}
