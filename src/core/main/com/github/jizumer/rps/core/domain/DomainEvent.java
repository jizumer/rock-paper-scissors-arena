package com.github.jizumer.rps.core.domain;

import java.util.UUID;

public abstract class DomainEvent {
    private final String eventId;

    public DomainEvent() {
        this.eventId = UUID.randomUUID().toString();
    }

    public String getEventId() {
        return eventId;
    }
}
