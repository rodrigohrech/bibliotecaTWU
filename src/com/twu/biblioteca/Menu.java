package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by rrech on 6/10/16.
 */
public class Menu {

    private static final String tab = "      ";
    public static final int LIST_BOOKS_OPTION = 1;
    public static final int RETURN_BOOK_OPTION = 2;
    public static final int MAIN_MENU = 0;
    private int positionMenu;
    private Catalogue catalogue;

    public Menu(Catalogue catalogue) {
        this.catalogue = catalogue;
        catalogue.initCatalogue();
        positionMenu = MAIN_MENU;
    }

    public void executeOption(int optionNumber) throws InvalidOptionException {

        switch (optionNumber) {
            case LIST_BOOKS_OPTION:
                System.out.println(Message.getCatalogueWindow(catalogue.getAvailableBooks()));
                System.out.println(checkOutBookOption(readInput()));
                executeOption(MAIN_MENU);
                break;

            case RETURN_BOOK_OPTION:
                System.out.println("Write book's name to return: ");
                System.out.println(returnBookOption(readInput()));
                executeOption(MAIN_MENU);
                break;

            case MAIN_MENU:
                System.out.println(Message.getWelcomeMessage());
                break;

            default:
                    throw new InvalidOptionException();

        }


    }

    public String returnBookOption(String name) {
        return Message.getReturnBookMessage(catalogue.returnBook(name));
    }


    public String checkOutBookOption(String name) {
        return Message.getCheckoutBookMessage(catalogue.checkOut(name));
    }

    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
