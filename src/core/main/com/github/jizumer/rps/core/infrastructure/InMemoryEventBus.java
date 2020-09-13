package com.github.jizumer.rps.core.infrastructure;

import com.github.jizumer.rps.core.domain.DomainEvent;
import com.github.jizumer.rps.core.domain.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


//This is a way to mitigate coupling with Spring infrastructure. Not so clean as it would be not having absolutely
//no reference to Spring stuff into our shared kernel, but cleaner than implementing abstract classes everywhere
@Service
public class InMemoryEventBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public InMemoryEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    @Override
    public void publish(DomainEvent domainEvent) {
        System.out.println(String.format("Publising event: %s", domainEvent));
        publisher.publishEvent(domainEvent);
    }
}
