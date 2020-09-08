package com.github.jizumer.rps.core.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Identifier {
    private final String value;

    public Identifier(String value) {
        validate(value);
        this.value = value;
    }


    private void validate(String value) throws IllegalArgumentException {
        //throws IllegalArgumentException in case of not valid UUID
        //noinspection ResultOfMethodCallIgnored
        UUID.fromString(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier identifier = (Identifier) o;
        return value.equals(identifier.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
