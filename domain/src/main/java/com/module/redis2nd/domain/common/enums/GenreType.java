package com.module.redis2nd.domain.common.enums;

import lombok.Getter;

@Getter
public enum GenreType {
    ACTION("액션")
    ,MELODRAMA("멜로")
    ,COMEDY("코미디")
    ;

    private String genreName;

    GenreType(String genreName) {
        this.genreName = genreName;
    }
}
