package com.hanghae.booking;

import lombok.Getter;

@Getter
public class BookScreeningSuccessEvent {
    private Long memberId;

    private Long screeningId;

    public BookScreeningSuccessEvent(Long memberId, Long screeningId) {
        this.memberId = memberId;
        this.screeningId = screeningId;
    }
}
