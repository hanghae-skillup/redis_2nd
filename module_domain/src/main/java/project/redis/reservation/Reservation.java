package project.redis.reservation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import project.redis.screening.Screening;
import project.redis.seat.Seat;
import project.redis.user.User;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Reservation {

    private Long reservationId;
    @Getter
    private Screening screening;
    @Getter
    private Seat seat;
    @Getter
    private User user;

    public static Reservation create(Long reservationId, Seat seat, Screening screening, User user) {
        return new Reservation(reservationId, screening, seat, user);
    }

    public static Reservation create(Seat seat, Screening screening, User user) {
        return new Reservation(null, screening, seat, user);
    }

    public Boolean isSeatReserved(String seatRow, Integer seatCol) {
        return this.seat.isThisSeat(seatRow, seatCol);
    }


}
