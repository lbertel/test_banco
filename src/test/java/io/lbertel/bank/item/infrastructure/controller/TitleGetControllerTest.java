package io.lbertel.bank.item.infrastructure.controller;

import io.lbertel.bank.item.domain.Item;
import io.lbertel.bank.item.domain.ItemMother;
import io.lbertel.bank.item.use_case.WithAverageRatingLowerThanUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TitleGetControllerTest {

    @Test
    void should_return_status_ok_and_title_list(){
        //given
        int expectValue = 2;
        HttpStatus expectedStatusCode = HttpStatus.OK;
        List<Item> items = ItemMother.create();

        WithAverageRatingLowerThanUseCase useCase = mock(WithAverageRatingLowerThanUseCase.class);
        when(useCase.execute(any())).thenReturn(items);

        //when
        TitleGetController controller = new TitleGetController(useCase);
        ResponseEntity<List<String>> titles = controller.titles(3.0);
        HttpStatus currentStatusCode = titles.getStatusCode();
        int currentValue = Objects.requireNonNull(titles.getBody()).size();

        //then
        assertThat(expectValue, is(equalTo(currentValue)));
        assertThat(expectedStatusCode, is(equalTo(currentStatusCode)));
    }

}