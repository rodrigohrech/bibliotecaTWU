package com.twu.biblioteca;

import java.util.Date;

/**
 * Created by rrech on 6/10/16.
 */
public class Book {
    private String name;
    private int ID;
    private Date yearPublished;
    private String author;
    private boolean available;

    public Book(boolean available) {
        this.available = available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getYearPublished() {
        return yearPublished.getYear()+1900;
    }

    public void setYearPublished(Date yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
