package com.twu.biblioteca;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;


public class MenuTest {

    public static final int LIST_BOOKS_OPTION = 1;
    public static final int INVALID_OPTION = -1;
    public static final String BOOK_AVAILABLE = "Book available";
    public static final String BOOK_UNAVAILABLE = "Book unavailable";
    public static final boolean IS_SUCCESS = true;
    public static final boolean IS_FAILURE = false;
    private Menu menu;
    @Before
    public void setUp() {
        Catalogue catalogue = mock(Catalogue.class);
        when(catalogue.checkOut(BOOK_AVAILABLE)).thenReturn(IS_SUCCESS);
        when(catalogue.checkOut(BOOK_UNAVAILABLE)).thenReturn(IS_FAILURE);
        when(catalogue.returnItem(BOOK_UNAVAILABLE)).thenReturn(IS_SUCCESS);
        when((catalogue.returnItem(BOOK_AVAILABLE))).thenReturn(IS_FAILURE);
        menu = new Menu(catalogue);
    }


    @Test
    public void shouldReturnSuccessMessageWhenCheckoutBook() throws Exception {
        assertEquals(Message.getCheckoutBookMessage(IS_SUCCESS),menu.checkOutBookOption(BOOK_AVAILABLE));
    }

    @Test
    public void shouldReturnFailureMessageWhenCheckoutBook() throws Exception {
        assertEquals(Message.getCheckoutBookMessage(IS_FAILURE),menu.checkOutBookOption(BOOK_UNAVAILABLE));

    }

    @Test
    public void shouldReturnSuccessMessageWhenReturnBook() throws Exception {
        assertEquals(Message.getReturnBookMessage(IS_SUCCESS), menu.returnBookOption(BOOK_UNAVAILABLE));

    }

    @Test
    public void shouldReturnFailureMessageWhenReturnBook() throws Exception {
        assertEquals(Message.getReturnBookMessage(IS_FAILURE), menu.returnBookOption(BOOK_AVAILABLE));
    }


}
