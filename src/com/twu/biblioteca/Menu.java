package com.twu.biblioteca;

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

    public Menu() {
        catalogue = new Catalogue();
        catalogue.initCatalogue();
        positionMenu = MAIN_MENU;
    }

    public void executeOption(int optionNumber) throws InvalidOptionException {


        switch (optionNumber) {
            case LIST_BOOKS_OPTION:
                checkOutBookOption();
                executeOption(MAIN_MENU);
                break;

            case RETURN_BOOK_OPTION:
                returnBookOption();
                executeOption(MAIN_MENU);
                break;

            case MAIN_MENU:
                printWelcomeMessage();
                break;

            default:
                    throw new InvalidOptionException();

        }


    }

    private void returnBookOption() {
        System.out.println("Write book's name to return: ");
        if(catalogue.returnBook(catalogue.getBookByName(BibliotecaApp.readInput()))) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    private void checkOutBook(String name) {
        if(catalogue.checkOut(catalogue.getBookByName(name)))
            System.out.println("Thank you! Enjoy the book");
        else {
            System.out.println("That book is not available.");
        }
    }

    private void checkOutBookOption() {
        System.out.println("\nCatalogue List:\n");
        printHorizontalLine();
        System.out.println(tab+"| ID | Name  | Author | Year Published");
        printHorizontalLine();


        for (Book book : catalogue.getAvailableBooks()) {
            System.out.println(tab +    "| " + book.getID()
                    +  " | " + book.getName()
                    +  " | " + book.getAuthor()
                    +  " | " + book.getYearPublished()
                    +  " | ");
        }
        printHorizontalLine();

        System.out.print("\nWhat book do you want? <Name> ");

        checkOutBook(BibliotecaApp.readInput());
    }

    private void printWelcomeMessage() {
        System.out.println("------------ Welcome to MyBib! ------------\n");
        showOptions();

    }

    private void printHorizontalLine() {
        System.out.println(tab+"--------------------------------------");
    }

    public void showOptions() {
        System.out.println(tab+"OPTIONS:");
        System.out.println("\n"+tab+"1 - List Books");
        System.out.println("\n"+tab+"2 - Return Book");
        System.out.println("\nSelect your option (Number Only) or type Quit: ");
    }
}
