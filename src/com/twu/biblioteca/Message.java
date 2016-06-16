package com.twu.biblioteca;

import java.util.List;

/**
 * Created by rrech on 6/15/16.
 */
public class Message {

    private static final String tab = "      ";

    public final static String WELCOME = "------------ Welcome to MyBib! ------------";
    public final static String SUCCESS_RETURN_BOOK = "Thank you for returning the book.";
    public final static String FAILURE_RETURN_BOOK = "That is not a valid book to return.";
    public final static String SUCCESS_CHECKOUT_BOOK = "Thank you! Enjoy the book";
    public final static String FAILURE_CHECKOUT_BOOK = "That book is not available.";
    public final static String HORIZONTAL_LINE = tab + "--------------------------------------";

    private final static String CATALOGUE_HEAD = "\nCatalogue List:\n";
    private final static String CATALOGUE_LIST_HEADER = tab + "| ID | Name  | Author | Year Published";

    public final static String getOptions() {
        return "\n" + tab + "OPTIONS:" +
                "\n" + tab + "1 - List Books" +
                "\n" + tab + "2 - Return Book" +
                "\nSelect your option (Number Only) or type Quit: ";
    }

    public final static String getWelcomeMessage() {
        return WELCOME + getOptions();
    }

    public static String getCatalogueWindow(List<Book> bookList) {
        StringBuilder window = new StringBuilder();

        window.append(CATALOGUE_HEAD +
                HORIZONTAL_LINE +
                CATALOGUE_LIST_HEADER);

        for (Book book : bookList) {
            window.append(tab + "| " + book.getID()
                    + " | " + book.getName()
                    + " | " + book.getAuthor()
                    + " | " + book.getYearPublished()
                    + " | ");
        }

        window.append(HORIZONTAL_LINE);

        window.append("\nWhat book do you want? <Name> ");

        return window.toString();
    }

    public static String getCheckoutBookMessage(boolean isSuccess) {
        return isSuccess ? SUCCESS_RETURN_BOOK : FAILURE_RETURN_BOOK;
    }

    public static String getReturnBookMessage(boolean isSuccess) {
        return isSuccess ? SUCCESS_CHECKOUT_BOOK : FAILURE_CHECKOUT_BOOK;
    }
}
