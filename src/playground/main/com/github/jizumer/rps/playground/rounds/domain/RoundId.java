package com.github.jizumer.rps.playground.rounds.domain;

import java.util.Objects;

public final class RoundId {
    private final String value;

    public RoundId(String value) {
        this.value = value;
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
