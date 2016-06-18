package com.twu.biblioteca;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BibliotecaApp {

    public static final String QUIT_COMMAND = "quit";
    private static Menu menu;
    private static String input;

    public static void initBibliotecaApp() {
        CatalogueBook catalogueBook = new CatalogueBook(new CatalogueBookFactory());
        CatalogueMovie catalogueMovie = new CatalogueMovie(new CatalogueMovieFactory());
        Credential credential = new Credential(new UserFactory());
        menu = new Menu(catalogueBook,catalogueMovie, credential);
        input = Integer.toString(Menu.LOGIN);
    }

    public static void main(String[] args) {

        initBibliotecaApp();

        while(input.toLowerCase().compareTo(QUIT_COMMAND) != 0) {
            try {
                menu.executeOption(Integer.parseInt(input));
            } catch (InvalidOptionException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option "
                                        + e.getMessage().toLowerCase()
                                        + ". Select a valid option!");
            }
            input = menu.readInput();
        }

    }



}
