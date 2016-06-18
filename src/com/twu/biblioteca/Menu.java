package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by rrech on 6/10/16.
 */
public class Menu {

    private static final String tab = "      ";
    public static final int LIST_BOOKS_OPTION = 1;
    private static final int LIST_MOVIES_OPTION = 2;
    public static final int RETURN_BOOK_OPTION = 3;
    public static final int MAIN_MENU = 0;
    public static final int LOGIN = -1;
    private final Credential credential;

    private int positionMenu;
    private CatalogueBook catalogueBook;
    private CatalogueMovie catalogueMovie;

    public Menu(CatalogueBook catalogueBook, CatalogueMovie catalogueMovie, Credential credential) {
        this.catalogueBook = catalogueBook;
        this.catalogueMovie = catalogueMovie;
        this.credential = credential;
        catalogueMovie.initCatalogue();
        catalogueBook.initCatalogue();

        positionMenu = MAIN_MENU;
    }

    public void executeOption(int optionNumber) throws InvalidOptionException {

        switch (optionNumber) {
            case LIST_BOOKS_OPTION:
                System.out.println(Message.getCatalogueBooksWindow(catalogueBook.getAvailableItems()));
                System.out.println(checkOutBookOption(readInput()));
                executeOption(MAIN_MENU);
                break;

            case LIST_MOVIES_OPTION:
                System.out.println(Message.getCatalogueMoviesWindow(catalogueMovie.getAvailableItems()));
                System.out.println(checkOutMovieOption(readInput()));
                executeOption(MAIN_MENU);
                break;

            case RETURN_BOOK_OPTION:
                System.out.println("Write book's name to return: ");
                System.out.println(returnBookOption(readInput()));
                executeOption(MAIN_MENU);
                break;

            case LOGIN:
                System.out.println(Message.WELCOME);
                System.out.println(Message.LOGIN);
                String user = readInput();
                System.out.println(Message.PASSWORD);
                String password = readInput();

                if(credential.login(user,password)) {
                    executeOption(MAIN_MENU);
                } else {
                    System.out.println(Message.INVALID_USER_OR_PASSWORD);
                    executeOption(LOGIN);
                }
                break;

            case MAIN_MENU:
                System.out.println(Message.getWelcomeMessage(credential.getSession()));
                break;

            default:
                    throw new InvalidOptionException();

        }


    }

    private String checkOutMovieOption(String name) {
        return Message.getReturnMovieMessage(catalogueMovie.checkOut(name));
    }

    public String returnBookOption(String name) {
        return Message.getReturnBookMessage(catalogueBook.returnItem(name));
    }


    public String checkOutBookOption(String name) {

        return Message.getCheckoutBookMessage(catalogueBook.checkOut(name));
    }

    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
