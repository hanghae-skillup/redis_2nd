package com.movie.movieapplication.movie.dto;

import com.movie.movieapplication.movie.domain.Theater;

public class TheaterInfo {

    public record Get(Long id, String name) {
        public static Get of(Long id, String name) {
            return new Get(id, name);
        }

        public static Get from(Theater theater) {
            return Get.of(theater.getId(), theater.getName());
        }
    }

}
