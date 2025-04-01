package com.hanghae.booking;

import com.hanghae.message.MessageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class BookingSuccessMessageHandler {
    private final MessageClient messageClient;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(BookScreeningSuccessEvent event) {
        messageClient.send(event.getMemberId(), "영화 예매 성공 축하 알림 문자");

    }
}
