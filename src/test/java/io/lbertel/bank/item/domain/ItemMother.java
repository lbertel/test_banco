package io.lbertel.bank.item.domain;

import java.util.ArrayList;
import java.util.List;

public final class ItemMother {

    public static List<Item> create() {
        List<Item> items = new ArrayList<>();
        List<Review> reviews1 = new ArrayList<>();
        List<Review> reviews2 = new ArrayList<>();

        reviews1.add(new Review("some review 1_1"));
        reviews1.add(new Review("some review 1_1"));

        reviews2.add(new Review("some review 2_1"));
        reviews2.add(new Review("some review 2_2"));
        reviews2.add(new Review("some review 2_3"));
        reviews2.add(new Review("some review 2_4"));

        items.add(new Item(new Title("some title 1"), reviews1, new Rating(0.0)));
        items.add(new Item(new Title("some title 2"), reviews2, new Rating(0.0)));

        return items;
    }

}
