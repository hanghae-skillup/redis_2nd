package com.hanghae.common.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PositiveNumber {
    private int value;

    public PositiveNumber(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다");
        }
        this.value = value;
    }
}
