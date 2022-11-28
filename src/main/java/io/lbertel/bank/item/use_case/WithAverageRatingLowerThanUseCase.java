package io.lbertel.bank.item.use_case;

import io.lbertel.bank.item.domain.Item;
import io.lbertel.bank.item.domain.Rating;
import io.lbertel.bank.item.domain.port.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WithAverageRatingLowerThanUseCase {

    private final ItemRepository repository;

    public WithAverageRatingLowerThanUseCase(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> execute(Rating rating){
        Optional<List<Item>> items = repository.getTitles(rating);
        if(items.isEmpty()){
            return new ArrayList<>();
        }
        return items.get();
    }

}
