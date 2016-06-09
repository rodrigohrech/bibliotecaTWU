package com.twu.biblioteca;

import java.awt.print.Book;
import java.util.ArrayList;
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
        catalogue = new ArrayList<Book>();

        Book book = new Book();
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();

        catalogue.add(book);
        catalogue.add(book1);
        catalogue.add(book2);
        catalogue.add(book3);
        catalogue.add(book4);
    }
}
