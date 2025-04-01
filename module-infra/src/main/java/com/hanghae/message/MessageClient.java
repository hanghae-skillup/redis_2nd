package com.hanghae.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageClient {
    
    public void send(Long memberId, String message) {
        log.info("{}님 영화 예매 성공했습니다. {}", memberId, message);
    }
}
