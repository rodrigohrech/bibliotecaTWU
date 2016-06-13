package com.twu.biblioteca;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BibliotecaApp {

    public static final String MAIN_MENU = "0";
    public static final String QUIT_COMMAND = "Quit";
    private static Menu menu = new Menu();;


    public static void main(String[] args) {
        String input = MAIN_MENU;

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
            input = readInput();
        }

    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
