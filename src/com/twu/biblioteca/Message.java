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

    private final static String CATALOGUE_BOOKS_HEAD = "\nCatalogue Books List:\n";
    private final static String CATALOGUE_BOOKS_LIST_HEADER = tab + "| ID | Name  | Author | Year Published";
    private final static String CATALOGUE_MOVIES_LIST_HEADER = tab + "| ID | Name  | Director | Year Published | Rating";
    private static final String CATALOGUE_MOVIES_HEAD = "\nCatalogue Movies List:\n";;

    public final static String getOptions() {
        return "\n" + tab + "OPTIONS:" +
                "\n" + tab + "1 - List Books" +
                "\n" + tab + "2 - List Movies" +
                "\n" + tab + "3 - Return Book" +
                "\nSelect your option (Number Only) or type Quit: ";
    }

    public final static String getWelcomeMessage() {
        return WELCOME + getOptions();
    }

    public static String getCatalogueBooksWindow(List<Book> bookList) {
        StringBuilder window = new StringBuilder();

        window.append(CATALOGUE_BOOKS_HEAD +
                HORIZONTAL_LINE +
                CATALOGUE_BOOKS_LIST_HEADER);

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

    public static String getCatalogueMoviesWindow(List<Movie> availableMovies) {
        StringBuilder window = new StringBuilder();

        window.append(CATALOGUE_MOVIES_HEAD +
                HORIZONTAL_LINE +
                CATALOGUE_MOVIES_LIST_HEADER);

        for (Movie movie : availableMovies) {
            window.append(tab + "| " + movie.getID()
                    + " | " + movie.getName()
                    + " | " + movie.getAuthor()
                    + " | " + movie.getYearPublished()
                    + " | " + (movie.getRating() == 0 ? "unrated" : movie.getRating()));
        }

        window.append(HORIZONTAL_LINE);

        window.append("\nWhat movie do you want? <Name> ");

        return window.toString();
    }
}
