package com.redis.application.message.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public void send(String message) {
        try {
            Thread.sleep(500); // 메시지 발송 모사
            System.out.println("메시지 발송 완료: " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
