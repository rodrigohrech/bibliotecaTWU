package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        printWelcomeMessage();

        printCatalogueList();

    }

    private static void printCatalogueList() {
        System.out.println("\n Catalogue List: ");
        Library library = new Library();

        library.initCatalogue();

        List<Book> catalogue = library.getAllBooks();

        for (Book book : catalogue) {
            System.out.println("    " + book.getID() + " - "+book.getName());
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("------------ Welcome to MyBib! ------------");
    }
}
