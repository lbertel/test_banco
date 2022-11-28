package io.lbertel.bank.item.infrastructure.persistence;

import io.lbertel.bank.item.domain.Item;
import io.lbertel.bank.item.domain.Rating;
import io.lbertel.bank.item.domain.Review;
import io.lbertel.bank.item.domain.Title;
import io.lbertel.bank.item.domain.port.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FakeItemRepository implements ItemRepository {

    List<Review> ratings1 = new ArrayList<>();
    List<Review> ratings2 = new ArrayList<>();

    List<Item> items = new ArrayList<>();

    @Override public Optional<List<Item>> getTitles(Rating rating) {
        populateItems();
        List<Item> filterItems = items.stream()
                                 .filter(item -> item.getReview().size() < rating.getValue().intValue())
                                 .collect(Collectors.toList());
        return Optional.of(filterItems);
    }

    private void populateItems(){
        ratings1.add(new Review("Rating 1_1"));
        ratings1.add(new Review("Rating 1_2"));

        ratings2.add(new Review("Rating 2_1"));
        ratings2.add(new Review("Rating 2_2"));
        ratings2.add(new Review("Rating 2_3"));
        ratings2.add(new Review("Rating 2_4"));

        items.add(new Item(new Title("Item 1"), ratings1, new Rating(0.0)));
        items.add(new Item(new Title("Item 2"), ratings2, new Rating(9.0)));
    }

}
