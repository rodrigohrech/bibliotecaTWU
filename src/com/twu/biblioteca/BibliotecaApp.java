package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BibliotecaApp {

    private static String tab = "      ";

    public static void main(String[] args) {

        printWelcomeMessage();

        printCatalogueList();

        System.out.print("\nWhat book do you want? (Number Only) ");
        int option =  readInteger();

    }

    private static int readInteger() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            return Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
            return -1;
        } catch (IOException e) {
            System.out.println("Invalid Input");
            return -1;
        }
    }

    private static void printCatalogueList() {
        System.out.println("\nCatalogue List:\n");
        printHorizontalLine();
        System.out.println(tab+"| ID | Name  | Author | Year Published");
        printHorizontalLine();

        Library library = new Library();

        library.initCatalogue();

        List<Book> catalogue = library.getAllBooks();

        for (Book book : catalogue) {
            System.out.println(tab +    "| " + book.getID()
                                    +  " | " + book.getName()
                                    +  " | " + book.getAuthor()
                                    +  " | " + book.getYearPublished()
                                    +  " | ");
        }
        printHorizontalLine();
    }

    private static void printHorizontalLine() {
        System.out.println(tab+"--------------------------------------");
    }

    private static void printWelcomeMessage() {
        System.out.println("------------ Welcome to MyBib! ------------");
    }
}
