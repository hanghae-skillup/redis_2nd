package com.pepponechoi.cinema.movie.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Genre {
    ACTION("액션", "ACTION"),
    ROMANCE("로맨스", "ROMANCE"),
    HORROR("호러", "HORROR"),
    SF("SF", "SF");
    private final String value;
    private final String code;
}
