package com.movie.movieapplication.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rating {

    RATING_ALL("전체관뢈가", 0),
    RATING_12("12세 관람가", 10),
    RATING_15("15세 관람가", 20),
    RATING_19("19세 관람가", 30),
    ;

    private final String kor;
    private final int value;

}
