package io.lbertel.bank.item.domain;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReviewTest {

    @Test
    void should_create_a_review_instance() {
        //given
        String expectedValue = "some review";

        //when
        Review review = new Review(expectedValue);
        String currentValue = review.getValue();

        //then
        assertThat(expectedValue, is(equalTo(currentValue)));
    }

    @Test
    void should_throw_a_invalid_exception_when_review_is_null() {
        //given
        String expectedValue = "The review is null";

        //when
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            new Review(null);
        });
        String currentValue = exception.getMessage();

        //then
        assertThat(expectedValue, is(equalTo(currentValue)));
    }

}