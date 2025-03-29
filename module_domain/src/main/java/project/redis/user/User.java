package project.redis.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private Long userId;
    private String username;

    public static User of(Long userId, String username) {
        return new User(userId, username);
    }
}
