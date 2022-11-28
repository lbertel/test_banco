package io.lbertel.bank.item.domain;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TitleTest {

    @Test
    void should_create_a_title_instance(){
        //given
        String expectValue = "some title";

        //when
        Title title = new Title(expectValue);
        String currentValue = title.getValue();

        //then
        assertThat(currentValue, is(equalTo(expectValue)));
    }

    @Test
    void should_throw_invalid_exception_when_title_is_blank(){
        //given
        String blankValue = "";
        String expectValue = "The title is blank";

        //when
        Exception exception = assertThrows(InvalidParameterException.class, () -> new Title(blankValue));
        String currentValue = exception.getMessage();

        //then
        assertThat(currentValue, is(equalTo(expectValue)));
    }

    @Test
    void should_throw_invalid_exception_when_title_is_null(){
        //given
        String expectValue = "The title is null";

        //when
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            new Title(null);
        });
        String currentValue = exception.getMessage();

        //then
        assertThat(currentValue, is(equalTo(expectValue)));
    }

}