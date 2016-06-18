package com.twu.biblioteca;

/**
 * Created by rrech on 6/17/16.
 */
public class Customer extends User {

    public Customer(String account, String senha) {
        super(account, senha);
    }

    public Customer(String name, String email, String phone, String account, String password) {
        super(name, email, phone, account, password);
    }
}
