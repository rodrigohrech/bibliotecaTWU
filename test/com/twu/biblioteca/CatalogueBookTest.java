package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatalogueBookTest {


    private Catalogue<Book> catalogue;
    private List<Book> availableBooks;
    private List<Movie> availableMovies;

    @Before
    public void setUp(){
        CatalogueBookFactory catalogueBookFactory = new CatalogueBookFactory();
        catalogue = new Catalogue<Book>(catalogueBookFactory);
        catalogue.initCatalogue();
    }

    @Test
    public void shouldRemoveBookFromAvailableWhenCheckOut() throws Exception {
        availableBooks = catalogue.getAvailableItems();
        int numberBooks = availableBooks.size();
        catalogue.checkOut(availableBooks.get(0).getName());
        availableBooks = catalogue.getAvailableItems();
        assertNotEquals(numberBooks,availableBooks.size());

    }

    @Test
    public void shouldSetAvailableFalseWhenCheckOut() throws Exception {
        assertFalse(checkOutFirstBookFromAvailableList().isAvailable());

    }

    private Book checkOutFirstBookFromAvailableList() {
        availableBooks = catalogue.getAvailableItems();
        Book bookTest = availableBooks.get(0);
        catalogue.checkOut(bookTest.getName());
        return bookTest;
    }


    @Test
    public void shouldMoveBookFromAvailableListToCheckedBooksListWhenCheckOut() throws Exception {
        Book testBook = checkOutFirstBookFromAvailableList();
        assertFalse(catalogue.getAvailableItems().contains(testBook));
        assertTrue(catalogue.getCheckedOutItems().contains(testBook));

    }

    @Test
    public void shouldMoveMovieFromAvailableListToCheckedMoviesListWhenCheckOut() throws Exception {
        Book testBook = checkOutFirstBookFromAvailableList();
        assertFalse(catalogue.getAvailableItems().contains(testBook));
        assertTrue(catalogue.getCheckedOutItems().contains(testBook));

    }

    @Test
    public void shouldReturnAllBooks() throws Exception {
        assertTrue(catalogue.getAllItems().containsAll(catalogue.getAvailableItems()));
        assertTrue(catalogue.getAllItems().containsAll(catalogue.getCheckedOutItems()));
    }

    @Test
    public void shouldReturnAllMovies() throws Exception {
        assertTrue(catalogue.getAllItems().containsAll(catalogue.getAvailableItems()));
        assertTrue(catalogue.getAllItems().containsAll(catalogue.getCheckedOutItems()));
    }

    @Test
    public void shouldReturnBookByName() throws Exception {
        Book targetBook = catalogue.getAllItems().get(0);
        assertEquals(targetBook,catalogue.getItemByName(targetBook.getName()));
    }

    @Test
    public void shouldMoveBookFromCheckedOutListToAvailableListWhenReturn() throws Exception {
        checkOutFirstBookFromAvailableList();
        Book targetBook = catalogue.getCheckedOutItems().get(0);
        catalogue.returnItem(targetBook.getName());
        assertFalse(catalogue.getCheckedOutItems().contains(targetBook));
        assertTrue(catalogue.getAvailableItems().contains(targetBook));
    }

    @Test
    public void shouldChangeStatusAvaibleWhenBookReturned() throws Exception {
        Book targetBook = checkOutFirstBookFromAvailableList();
        catalogue.returnItem(targetBook.getName());
        assertTrue(targetBook.isAvailable());
    }
}
