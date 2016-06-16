package com.twu.biblioteca;

import java.util.Date;

/**
 * Created by rrech on 6/16/16.
 */
public class CatalogueBookFactory extends CatalogueFactory<Book> {
    @Override
    public Book createItem() {
        Book book = new Book(true);

        if(getCatalogue() != null)
            book.setID(nextId());
        else
            book.setID(getRandomInt());

        book.setName("Book " + book.getID());
        book.setYearPublished(new Date());
        book.setAuthor("Author "+ book.getID());
        return book;
    }
}
