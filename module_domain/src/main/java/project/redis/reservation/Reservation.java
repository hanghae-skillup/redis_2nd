package project.redis.reservation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import project.redis.screening.Screening;
import project.redis.seat.Seat;
import project.redis.user.User;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Reservation {

    private Long reservationId;
    private Screening screening;
    private Seat seat;
    private User user;

    public static Reservation create(Long reservationId, Seat seat, Screening screening, User user) {
        return new Reservation(reservationId, screening, seat, user);
    }

}
