package com.github.jizumer.rps.core.domain;

public interface EventBus {
    void publish(final DomainEvent events);
}
