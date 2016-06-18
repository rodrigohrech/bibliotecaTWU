package com.twu.biblioteca;

/**
 * Created by rrech on 6/17/16.
 */
public class CatalogueBook extends Catalogue<Book> {

    public CatalogueBook(CatalogueFactory<Book> catalogueFactory) {
        super(catalogueFactory);
    }
}
