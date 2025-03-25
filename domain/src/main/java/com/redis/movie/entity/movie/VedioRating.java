package com.redis.movie.entity.movie;

public enum VedioRating {

    ALL("전체관람가능"),
    AGE_12("12세이상관람"),
    AGE_15("15세이상관람"),
    AGE_19("청소년관람불가"),
    RESTRICTED("제한관람가");

    private final String description;


    VedioRating(String description) {
        this.description = description;
    }
}
