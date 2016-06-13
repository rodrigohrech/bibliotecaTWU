package com.twu.biblioteca;

/**
 * Created by rrech on 6/10/16.
 */
public class InvalidOptionException extends Exception {

    @Override
    public String getMessage() {
        return "Select a valid option!";
    }
}
