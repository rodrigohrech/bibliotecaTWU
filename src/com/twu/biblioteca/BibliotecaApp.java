package com.twu.biblioteca;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BibliotecaApp {

    public static final String MAIN_MENU = "0";
    public static final String QUIT_COMMAND = "Quit";
    private static Menu menu;

    public BibliotecaApp() {
        Catalogue catalogue = new Catalogue();
        this.menu = new Menu(catalogue);
    }

    public static void main(String[] args) {
        String input = MAIN_MENU;
        int option;

        while(input != QUIT_COMMAND) {
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
