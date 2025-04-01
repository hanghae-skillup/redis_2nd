package project.redis.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageLogService implements MessageService {
    @Override
    public void send() {
        try {
            Thread.sleep(500);
            log.info("reservation success");
        } catch (InterruptedException e) {
            throw new RuntimeException("message send failed");
        }
    }
}
