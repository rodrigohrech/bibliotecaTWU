package com.twu.biblioteca;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rrech on 6/10/16.
 */
public abstract class CatalogueFactory<T extends Item> {


    private List<T> catalogue;

    public List<T> getCatalogue() {
        return catalogue;
    }

    public List<T> generate() {
        catalogue = new ArrayList<T>();

        for (int i = 0; i < 5; i++) {
            catalogue.add((T) createItem());
        }

        return catalogue;
    }

    public abstract T createItem();

    public int nextId() {
        return catalogue.size()+1;
    }

    public   int getRandomInt() {
        return Math.round((float) Math.random()*10);
    }

}
