package com.hanghae.theater;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ScreeningTime {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ScreeningTime(LocalDateTime startTime, LocalDateTime endTime) {
        validate(startTime, endTime);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private void validate(LocalDateTime startTime, LocalDateTime endTime) {
        Objects.requireNonNull(startTime, "상영 시작 시간을 입력하세요");
        Objects.requireNonNull(endTime, "상영 종료 시간을 입력하세요");
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("상영 종료 시간은 상영 시작 시간 이후 시간입니다");
        }
    }

    public boolean isBefore(LocalDate otherDate) {
        LocalDate endDate = endTime.toLocalDate();
        return otherDate.isAfter(endDate) || otherDate.isEqual(endDate);
    }
}
