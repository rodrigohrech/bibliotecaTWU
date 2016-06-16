package com.twu.biblioteca;

/**
 * Created by rrech on 6/16/16.
 */
public class Movie extends Item {

    private int rating;

    public Movie(boolean available) {
        super(available);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
