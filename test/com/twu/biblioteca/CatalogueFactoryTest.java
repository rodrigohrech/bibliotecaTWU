package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CatalogueFactoryTest {
    @Test
    public void shouldReturnBookWhenCreateBook() throws Exception {
        assertTrue(CatalogueFactory.createBook() instanceof Book);
    }

    @Test
    public void shouldReturnListWith5BooksAfterGenerateCatalogue() {
        CatalogueFactory factory = new CatalogueFactory();

        assertEquals(5,factory.generate().size());
    }

}
