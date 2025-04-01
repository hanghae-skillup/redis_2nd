package com.pepponechoi.cinema.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisherImpl implements EventPublisher {
    private final ApplicationEventPublisher eventPublisher;
    @Override
    public void publish(Object event) {
        eventPublisher.publishEvent(event);
    }
}
