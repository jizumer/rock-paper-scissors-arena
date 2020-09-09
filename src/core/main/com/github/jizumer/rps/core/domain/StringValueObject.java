package com.github.jizumer.rps.core.domain;

import java.util.Objects;

public abstract class StringValueObject {
    private final String value;

    public StringValueObject(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) throws IllegalArgumentException {
        //In this particular case, we wont accept empty strings
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("No empty or null values are accepted.");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StringValueObject)) {
            return false;
        }
        StringValueObject that = (StringValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
