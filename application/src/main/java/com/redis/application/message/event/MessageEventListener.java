package com.redis.application.message.event;

import com.redis.application.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageEventListener {

    private final MessageService messageService;

    @EventListener
    public void handleReservationCompletedEvent(ReservationCompletedEvent event) {
        // 메시지 발송 처리
        String message = String.format(
                "예약 완료!\n 예약 번호: %d\n 상영 정보: %s\n 고객 이메일: %s",
                event.getReserId(),
                event.getScreeningInfo(),
                event.getUserEmail()

        );

        messageService.send(message);
    }
}
