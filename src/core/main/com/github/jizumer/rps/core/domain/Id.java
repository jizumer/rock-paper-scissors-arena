package com.github.jizumer.rps.core.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Id {
    private String value;

    public Id(String value) {
        validate(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    private void validate(String value) throws IllegalArgumentException {
        //throws IllegalArgumentException in case of not valid UUID
        UUID.fromString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return value.equals(id.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
