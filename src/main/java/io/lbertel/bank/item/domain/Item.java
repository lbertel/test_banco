package io.lbertel.bank.item.domain;

import java.util.List;
import java.util.Objects;

public final class Item {

    private final Title title;
    private final List<Review> review;
    private final Rating rating;

    public Item(Title title, List<Review> review, Rating rating) {
        this.title = title;
        this.review = review;
        this.rating = rating;
    }

    public Title getTitle() {
        return title;
    }

    public List<Review> getReview() {
        return review;
    }

    public Rating getRating() {
        return rating;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(title, item.title) &&
                Objects.equals(review, item.review) &&
                Objects.equals(rating, item.rating);
    }

    @Override public int hashCode() {
        return Objects.hash(title, review, rating);
    }
}
