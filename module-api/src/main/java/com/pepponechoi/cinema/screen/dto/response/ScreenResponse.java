package com.pepponechoi.cinema.screen.dto.response;

import com.pepponechoi.cinema.screen.entity.Screen;

public record ScreenResponse(
    Long id,
    String name
) {
    public static ScreenResponse of(Screen screen) {
        return new ScreenResponse(screen.getId(), screen.getName());
    }
}
