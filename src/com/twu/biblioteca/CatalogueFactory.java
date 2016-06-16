package com.twu.biblioteca;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by rrech on 6/10/16.
 */
public class CatalogueFactory {

    private static List<Book> catalogue;

    public static List<Book> generate() {
        catalogue = new ArrayList<Book>();

        for (int i = 0; i < 5; i++) {
            catalogue.add(createBook());
        }

        return catalogue;
    }

    public static Book createBook() {
        Book book = new Book(true);

        if(catalogue != null)
            book.setID(nextId());
        else
            book.setID(getRandomInt());

        book.setName("Book " + book.getID());
        book.setYearPublished(new Date());
        book.setAuthor("Author "+ book.getID());

        return book;
    }

    private static int nextId() {
        return catalogue.size()+1;
    }

    private static int getRandomInt() {
        return Math.round((float) Math.random()*10);
    }
}
