package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrech on 6/12/16.
 */
public class Catalogue {

    private List<Book> checkedOutBooks;
    private List<Book> availableBooks;


    public void initCatalogue() {
        availableBooks =  CatalogueFactory.generate();
        checkedOutBooks = new ArrayList<Book>();
    }


    public List<Book> getAvailableBooks() {
        return availableBooks;
    }


    public boolean checkOut(String name) {
        Book book = getBookByName(name);
        if(availableBooks.remove(book)) {
            checkedOutBooks.add(book);
            book.setAvailable(false);
            return true;
        } else {
            return false;
        }
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<Book>();
        allBooks.addAll(availableBooks);
        allBooks.addAll(checkedOutBooks);
        return allBooks;
    }

    public Book getBookByName(String name) {
        for (Book book : getAllBooks()) {
            if(book.getName().contentEquals(name)) return book;
        }
        return null;
    }

    public boolean returnBook(String name) {
        Book book = getBookByName(name);
        if(checkedOutBooks.remove(book)) {
            availableBooks.add(book);
            book.setAvailable(true);
            return true;
        } else {
            return false;
        }
    }

}
