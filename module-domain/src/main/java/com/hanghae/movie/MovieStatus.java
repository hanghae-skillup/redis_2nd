package com.hanghae.movie;

public enum MovieStatus {
    NONE("상연 안 함"),
    SHOWING("상영 중"),
    COMING_SOON("개봉 예정");

    private String description;

    MovieStatus(final String description) {
        this.description = description;
    }
}
