package io.lbertel.bank.item.domain.port;

import io.lbertel.bank.item.domain.Item;
import io.lbertel.bank.item.domain.Rating;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Optional<List<Item>> getTitles(Rating rating);
}
