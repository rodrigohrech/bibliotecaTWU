package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CredentialTest {

    public static final String USER_CORRECT = "user_correct";
    public static final String PASSWORD_CORRECT = "password_correct";
    private static final String USER_INCORRECT = "user_incorrect";
    private static final String PASSWORD_INCORRECT = "password_incorrect";
    private UserFactory userFactory;
    private Credential credential;
    private Customer customerUser;
    @Before
    public void setUp() throws Exception {
        this.userFactory = new UserFactory();
        this.credential = new Credential(userFactory);
        this.customerUser = userFactory.getCustomer();
    }

    @Test
    public void shouldReturnTrueWhenLoginWithCorrectCredentials() {
        assertTrue(credential.login(customerUser.getAccount(), customerUser.getPassword()));
    }

    @Test
    public void shouldReturnFalseWhenLoginIncorrectUsername() throws Exception {
        assertFalse(credential.login(USER_INCORRECT, PASSWORD_CORRECT));
    }

    @Test
    public void shouldReturnFalseWhenLoginWithIncorrectPassword() throws Exception {
        assertFalse(credential.login(USER_CORRECT,PASSWORD_INCORRECT));
    }

    @Test
    public void shouldReturnLoginSessionAfterLogin() throws Exception {
        assertTrue(credential.login(customerUser.getAccount(), customerUser.getPassword()));
        assertEquals(customerUser,credential.getSession());

    }
}
