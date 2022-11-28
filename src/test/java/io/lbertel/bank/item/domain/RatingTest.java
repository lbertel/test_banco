package io.lbertel.bank.item.domain;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RatingTest {

    @Test
    void should_crate_a_rating_instance() {
        //given
        Double expectedValue = 3.0;

        //when
        Rating rating = new Rating(expectedValue);
        Double currentValue = rating.getValue();

        //then
        assertThat(expectedValue, is(equalTo(currentValue)));
    }

    @Test
    void should_throw_invalid_exception_when_rating_is_null() {
        //given
        String expectedValue = "The rating is null";

        //when
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            new Rating(null);
        });

        String currentValue = exception.getMessage();

        //then
        assertThat(expectedValue, is(equalTo(currentValue)));
    }

    @Test
    void should_throw_invalid_exception_when_rating_is_negative() {
        //given
        String expectedValue = "The rating is negative";

        //when
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            new Rating(-5.0);
        });

        String currentValue = exception.getMessage();

        //then
        assertThat(expectedValue, is(equalTo(currentValue)));
    }
}