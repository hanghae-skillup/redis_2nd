package com.pepponechoi.cinema.screen.dto.response;

import com.pepponechoi.cinema.screen.entity.Screen;
import lombok.Data;

@Data
public class ScreenResponse {
    private Long id;
    private String name;

    public ScreenResponse(Screen screen) {
        this.id = screen.getId();
        this.name = screen.getName();
    }
}
