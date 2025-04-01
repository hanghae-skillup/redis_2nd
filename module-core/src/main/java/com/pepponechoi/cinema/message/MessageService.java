package com.pepponechoi.cinema.message;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
    public void send(Long memberId, String message) {
        try {
            System.out.println("Reservation created. memberId: " + memberId + " message send: " + message);
            Thread.sleep(500);
            System.out.println("Message sent.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
