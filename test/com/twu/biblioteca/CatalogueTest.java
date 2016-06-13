package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatalogueTest {


    private Catalogue catalogue;
    private List<Book> availableBooks;

    @Before
    public void setUp(){
        catalogue = new Catalogue();
        catalogue.initCatalogue();
    }

    @Test
    public void shouldRemoveBookFromAvailableWhenCheckOut() throws Exception {
        availableBooks = catalogue.getAvailableBooks();
        int numberBooks = availableBooks.size();
        catalogue.checkOut(availableBooks.get(0));
        availableBooks = catalogue.getAvailableBooks();
        assertNotEquals(numberBooks,availableBooks.size());

    }

    @Test
    public void shouldSetAvailableFalseWhenCheckOut() throws Exception {
        assertFalse(checkOutFirstBookFromAvailableList().isAvailable());

    }

    private Book checkOutFirstBookFromAvailableList() {
        availableBooks = catalogue.getAvailableBooks();
        Book bookTest = availableBooks.get(0);
        catalogue.checkOut(bookTest);
        return bookTest;
    }

    @Test
    public void shouldMoveBookFromAvailableListToCheckedBooksListWhenCheckOut() throws Exception {
        Book testBook = checkOutFirstBookFromAvailableList();
        assertFalse(catalogue.getAvailableBooks().contains(testBook));
        assertTrue(catalogue.getCheckedOutBooks().contains(testBook));

    }

    @Test
    public void shouldReturnAllBooks() throws Exception {
        assertTrue(catalogue.getAllBooks().containsAll(catalogue.getAvailableBooks()));
        assertTrue(catalogue.getAllBooks().containsAll(catalogue.getCheckedOutBooks()));
    }

    @Test
    public void shouldReturnBookByName() throws Exception {
        Book targetBook = catalogue.getAllBooks().get(0);
        assertEquals(targetBook,catalogue.getBookByName(targetBook.getName()));
    }

    @Test
    public void shouldMoveBookFromCheckedOutListToAvailableListWhenReturn() throws Exception {
        checkOutFirstBookFromAvailableList();
        Book targetBook = catalogue.getCheckedOutBooks().get(0);
        catalogue.returnBook(targetBook);
        assertFalse(catalogue.getCheckedOutBooks().contains(targetBook));
        assertTrue(catalogue.getAvailableBooks().contains(targetBook));
    }

    @Test
    public void shouldChangeStatusAvaibleWhenBookReturned() throws Exception {
        Book targetBook = checkOutFirstBookFromAvailableList();
        catalogue.returnBook(targetBook);
        assertTrue(targetBook.isAvailable());
    }
}
