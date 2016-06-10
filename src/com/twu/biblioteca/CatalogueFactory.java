package com.twu.biblioteca;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrech on 6/10/16.
 */
public class CatalogueFactory {

    private static ArrayList<Book> catalogue;

    public static List<Book> generate() {
        catalogue = new ArrayList<Book>();

        for (int i = 0; i < 4; i++) {
            catalogue.add(createBook());
        }

        return catalogue;
    }

    public static Book createBook() {
        Book book = new Book();
        book.setName("Book " + nextId());

        if(catalogue != null)
            book.setID(nextId());
        else
            book.setID(getRandomInt());

        return book;
    }

    private static int nextId() {
        return catalogue.size()+1;
    }

    private static int getRandomInt() {
        return Math.round((float) Math.random()*10);
    }
}
