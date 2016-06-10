package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rrech on 6/9/16.
 */
public class LibraryTest {

    @Before
    public void setUp(){

    }

    @Test
    public void shouldReturnNotEmptyList() {
        Library library = new Library();

        library.initCatalogue();

        assertFalse(library.getAllBooks().isEmpty());
    }

    @Test
    public void shoudlReturn5ItemsAfterCatalogueInit(){
        Library library = new Library();

        library.initCatalogue();

        assertEquals(5,library.getAllBooks().size());
    }


}
