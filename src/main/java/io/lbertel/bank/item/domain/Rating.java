package io.lbertel.bank.item.domain;

import java.security.InvalidParameterException;
import java.util.Objects;

public final class Rating {

    private final Double value;

    public Rating(Double value) {
        if (value == null) {
            throw new InvalidParameterException("The rating is null");
        }
        if (value < 0) {
            throw new InvalidParameterException("The rating is negative");
        }
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rating rating = (Rating) o;
        return Objects.equals(value, rating.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
