package io.lbertel.bank.item.domain;

import java.security.InvalidParameterException;
import java.util.Objects;

public final class Title {

    private static final int MAX_LENGTH_TITLE = 100;

    private final String value;

    public Title(String value) {
        if(value == null){
            throw  new InvalidParameterException("The title is null");
        }
        if(value.isBlank() || value.isEmpty()){
            throw  new InvalidParameterException("The title is blank");
        }
        if (value.length() >= MAX_LENGTH_TITLE){
            throw  new InvalidParameterException("The title has more than 100 character");
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
        Title title = (Title) o;
        return Objects.equals(value, title.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
