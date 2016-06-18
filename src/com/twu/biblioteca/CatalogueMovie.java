package com.twu.biblioteca;

/**
 * Created by rrech on 6/17/16.
 */
public class CatalogueMovie extends Catalogue<Movie> {

    public CatalogueMovie(CatalogueFactory<Movie> catalogueFactory) {
        super(catalogueFactory);
    }
}
