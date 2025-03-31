package org.bailey.domain.exception.schedule;

public class ScheduleListNotFoundException extends RuntimeException {
    public ScheduleListNotFoundException() {
        super("등록된 상영이 없습니다.");
    }
}