package com.skillup.domain;

public enum MovieRating {
    A0("전체 관람가"),
    A12("12세 이상 관람가"),
    A15("15세 이상 관람가"),
    A18("청소년 관람불가"),
    A99("제한상영가");

    private final String koreanDescription;

    // 생성자
    MovieRating(String koreanDescription) {
        this.koreanDescription = koreanDescription;
    }

    // 한글 설명을 가져오는 메소드
    public String getKoreanRating() {
        return koreanDescription;
    }
}
