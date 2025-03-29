package project.redis.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageLogService implements MessageService {
    @Override
    public void send() throws InterruptedException {
        Thread.sleep(500);
        log.info("reservation success");
    }
}
