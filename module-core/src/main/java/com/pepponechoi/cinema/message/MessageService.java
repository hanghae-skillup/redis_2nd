package com.pepponechoi.cinema.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageService {
    public void send(Long memberId, String message) {
        try {
            log.info("Reservation created. memberId: {} message send: {}", memberId, message);
            Thread.sleep(500);
            log.info("Message sent.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
