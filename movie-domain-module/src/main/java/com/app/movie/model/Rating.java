package com.app.movie.model;

public enum Rating {
    G("전체관람가"),
    PG_12("12세 이상 관람가"),
    PG_15("15세 이상 관람가"),
    X_rated("청소년 관람불가");

    private final String description;

    Rating(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
