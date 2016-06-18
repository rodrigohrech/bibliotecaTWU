package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrech on 6/12/16.
 */
public abstract class Catalogue <T extends Item>  {

    private CatalogueFactory<T> catalogueFactory;
    private List<T> checkedOutItems;
    private List<T> availableItems;

    public Catalogue(CatalogueFactory<T> catalogueFactory) {
        this.catalogueFactory = catalogueFactory;
    }

    public void initCatalogue() {
        availableItems =  catalogueFactory.generate();
        checkedOutItems = new ArrayList<T>();
    }


    public List<T> getAvailableItems() {
        return availableItems;
    }

    public boolean checkOut(String name) {
        T item = getItemByName(name);
        if(availableItems.remove(item)) {
            checkedOutItems.add(item);
            item.setAvailable(false);
            return true;
        } else {
            return false;
        }
    }

    public List<T> getCheckedOutItems() {
        return checkedOutItems;
    }

    public List<T> getAllItems() {
        List<T> allItems = new ArrayList<T>();
        allItems.addAll(availableItems);
        allItems.addAll(checkedOutItems);
        return allItems;
    }

    public T getItemByName(String name) {
        for (T item : getAllItems()) {
            if(item.getName().contentEquals(name)) return item;
        }
        return null;
    }

    public boolean returnItem(String name) {
        T item = getItemByName(name);
        if(checkedOutItems.remove(item)) {
            availableItems.add(item);
            item.setAvailable(true);
            return true;
        } else {
            return false;
        }
    }

}
