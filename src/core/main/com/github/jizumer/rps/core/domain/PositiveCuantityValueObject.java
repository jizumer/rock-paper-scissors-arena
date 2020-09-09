package com.github.jizumer.rps.core.domain;

import java.util.Objects;

public abstract class PositiveCuantityValueObject {
    private final long value;

    public PositiveCuantityValueObject(long value) {
        validate(value);
        this.value = value;
    }

    private void validate(long value) {
        if (value < 0) {
            throw new IllegalArgumentException(
                    String.format("Received %s, but value must be ge 0",
                            value));
        }
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveCuantityValueObject that = (PositiveCuantityValueObject) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
