package com.redis.application.message.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationCompletedEvent {
    private final Long reserId;
    private final String userEmail; // 유저 이메일
    private final String screeningInfo; // 메시지 발송 내용
}
