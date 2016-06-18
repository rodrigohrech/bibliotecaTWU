package com.twu.biblioteca;

/**
 * Created by rrech on 6/17/16.
 */
public abstract class User {

    private String phone;
    private String account;
    private String password;
    private String email;
    private String name;

    public User(String account, String senha) {

    }

    public User(String name, String email, String phone, String account, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!account.equals(user.account)) return false;
        return password.equals(user.password);

    }

    @Override
    public int hashCode() {
        int result = account.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    public boolean validate(String account, String password) {
        return this.account.compareTo(account) == 0 && this.password.compareTo(password) == 0;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
