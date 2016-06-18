package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrech on 6/17/16.
 */
public class Credential {

    private List<User> userList;

    private User userSession;

    public Credential(UserFactory userFactory) {
        this.userList = new ArrayList<>();
        this.userList.add(userFactory.getCustomer());
        this.userList.add(userFactory.getLibrarian());
    }

    public boolean login(String account, String password) {
        for (User u: userList) {
            if(u.validate(account,password)) {
                userSession = u;
                return true;
            }
        };
        return false;
    }

    public User getSession() {
        return userSession;
    }
}
