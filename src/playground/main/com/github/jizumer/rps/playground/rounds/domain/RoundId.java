package com.github.jizumer.rps.playground.rounds.domain;

import java.util.Objects;
import java.util.UUID;

public final class RoundId {
    private final String value;

    public RoundId(String id) {
        validate(id);
        this.value = id;
    }

    private void validate(String value) {
        //validate that an UUID can be created from the received String
        UUID.fromString(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundId roundId = (RoundId) o;
        return value.equals(roundId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
