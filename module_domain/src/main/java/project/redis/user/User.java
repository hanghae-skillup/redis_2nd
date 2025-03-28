package project.redis.user;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import project.redis.reservation.Reservation;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private Long userId;
    private String username;
    private List<Reservation> reservations;

    public static User of(Long userId, String username, List<Reservation> reservations) {
        return new User(userId, username, reservations);
    }

    public static User of(Long userId, String username) {
        return new User(userId, username, new ArrayList<>());
    }
}
