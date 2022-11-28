package io.lbertel.bank.item.domain;

import java.security.InvalidParameterException;
import java.util.Objects;

public final class Review {

    private final String value;

    public Review(String value) {
        if (value == null) {
            throw new InvalidParameterException("The review is null");
        }
        if (value.isEmpty() || value.isBlank()) {
            throw new InvalidParameterException("The review is empty");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Review review = (Review) o;
        return Objects.equals(value, review.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
