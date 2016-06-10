package com.twu.biblioteca;

import com.twu.biblioteca.Book;
import java.util.List;

/**
 * Created by rrech on 6/9/16.
 */
public class Library {


    private List<Book> catalogue;

    public List<Book> getAllBooks() {
        return catalogue;
    }

    public void initCatalogue() {
        catalogue =  CatalogueFactory.generate();
    }


}
