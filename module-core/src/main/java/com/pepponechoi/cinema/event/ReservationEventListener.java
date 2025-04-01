package com.pepponechoi.cinema.event;

import com.pepponechoi.cinema.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationEventListener {
    private final MessageService messageService;

    @EventListener
    public void handleReservationCompletedEvent(ReservationCompletedEvent event) {
        messageService.send(event.userId(), event.reservationId().toString() + "번 예약이 저장되었습니다.");
    }
}
