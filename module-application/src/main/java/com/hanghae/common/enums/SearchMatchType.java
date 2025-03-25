package com.hanghae.common.enums;

/*
* SQL where 조건의 검색 타입
* */
public enum SearchMatchType {
    LIKE("like"),
    EQUAL("="),
    CONCAT("concat"),
    NOT_LIKE("not like"),
    ;

    private final String description;

    SearchMatchType(String description) {
        this.description = description;
    }
}
