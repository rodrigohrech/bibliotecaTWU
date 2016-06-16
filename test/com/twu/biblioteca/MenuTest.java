package com.twu.biblioteca;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MenuTest {

    public static final int LIST_BOOKS_OPTION = 1;
    public static final int INVALID_OPTION = -1;
    private Menu menu;
    @Before
    public void setUp() {
        Catalogue catalogue = new Catalogue();

        menu = new Menu(catalogue);
    }

    @Test(expected = InvalidOptionException.class)
    public void shouldThrowExceptionWhenExecuteWrongOption() throws Exception{
        menu.executeOption(INVALID_OPTION);
    }

    @Test
    public void shouldExecuteListBooksWhenOptionIsSelectedWithoutException() throws Exception {
        menu.executeOption(LIST_BOOKS_OPTION);
    }
}
