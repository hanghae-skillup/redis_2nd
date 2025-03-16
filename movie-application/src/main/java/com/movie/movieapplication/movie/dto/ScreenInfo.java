package com.movie.movieapplication.movie.dto;

import com.movie.movieapplication.movie.domain.Screen;

public class ScreenInfo {

    public record Get(Long id, Long theaterId, String name) {
        public static Get from(Screen screen) {
            return new Get(screen.getId(), screen.getTheaterId(), screen.getName());
        }
    }

}
