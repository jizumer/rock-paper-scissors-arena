package com.github.jizumer.rps.core.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public abstract class DomainEvent {
    private final String id;
    private final String aggregateName;
    private final String timestamp;

    public DomainEvent(String aggregateName) {
        this.id = UUID.randomUUID().toString();
        this.aggregateName = aggregateName;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getId() {
        return id;
    }

    public String getAggregateName() {
        return aggregateName;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
