package com.pepponechoi.cinema.user.dto.response;

import com.pepponechoi.cinema.user.entity.User;

public record UserResponse(
    Long id,
    String email,
    String nickname
) {
    public static UserResponse of(final User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getNickname());
    }
}
