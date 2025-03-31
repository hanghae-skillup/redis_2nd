package org.bailey.domain.exception.schedule;

public class ScheduleNotFoundException extends RuntimeException {
    public ScheduleNotFoundException(Long id) {
        super("해당 상영이 존재하지 않습니다. ID = " + id);
    }
}