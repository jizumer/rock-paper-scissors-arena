package com.github.jizumer.rps.core.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class DomainEventPublisher {
    private List<DomainEvent> domainEvents;

    public DomainEventPublisher() {
        this.domainEvents = new ArrayList<>();
    }

    public List<DomainEvent> getDomainEvents() {
        List<DomainEvent> domainEvents = this.domainEvents;
        this.domainEvents = new ArrayList<>();
        return domainEvents;
    }

    protected void addEvent(DomainEvent domainEvent) {
        this.domainEvents.add(domainEvent);
    }
}
