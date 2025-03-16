package com.movie.movieapplication.movie.dto;

import com.movie.movieapplication.movie.domain.Theater;

public class TheaterInfo {

    public record Get(Long id, String name) {
        public static Get from(Theater theater) {
            return new Get(theater.getId(), theater.getName());
        }
    }

}
