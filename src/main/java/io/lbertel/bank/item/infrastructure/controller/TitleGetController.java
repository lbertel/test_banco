package io.lbertel.bank.item.infrastructure.controller;

import io.lbertel.bank.item.domain.Item;
import io.lbertel.bank.item.domain.Rating;
import io.lbertel.bank.item.use_case.WithAverageRatingLowerThanUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class TitleGetController {

    private final WithAverageRatingLowerThanUseCase useCase;

    public TitleGetController(WithAverageRatingLowerThanUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/titles/{rating}")
    public ResponseEntity<List<String>> titles(@PathVariable Double rating){

        List<Item> items = useCase.execute(new Rating(rating));
        List<String> titles = items.stream()
                                   .map(item -> item.getTitle().getValue())
                                   .collect(Collectors.toList());


        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

}
