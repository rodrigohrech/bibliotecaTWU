package com.twu.biblioteca;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rrech on 6/16/16.
 */
public class CatalogueMovieFactory extends CatalogueFactory<Movie> {
    @Override
    public Movie createItem() {
        Movie movie = new Movie(true);

        if(getCatalogue() != null)
            movie.setID(nextId());
        else
            movie.setID(getRandomInt());

        movie.setName("Movie " + movie.getID());
        movie.setYearPublished(new Date());
        movie.setAuthor("Director "+ movie.getID());
        movie.setRating(getRandomRating());
        return movie;
    }

    private  int getRandomRating() {
        return ThreadLocalRandom.current().nextInt(0,6);
    }
}
