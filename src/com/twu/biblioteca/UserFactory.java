package com.twu.biblioteca;

/**
 * Created by rrech on 6/17/16.
 */
public class UserFactory {


    public Customer getCustomer() {
        return new Customer("Kylo Ren","kren@thoughtworks.com","42 5555-5555","123-4567","1234");
    }

    public Librarian getLibrarian() {
        return new Librarian("Master Yoda","myoda@thoughtworks.com","42 5555-5555","321-7654","4321");
    }
}
