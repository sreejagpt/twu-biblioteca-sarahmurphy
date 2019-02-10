package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldHaveUsernamePasswordAccountTypeNameEmailAndAddress() {
        User user = new User();
    }

    @Test
    public void shouldLoginCustomerIfUsernameAndPasswordCorrect() {
        User user = new User();
        user.login("123-4567", "password123");
        assertThat(user.getUsername(), is("123-4567"));
    }

    @Test
    public void shouldLoginLibrarianIfUsernameAndPasswordCorrect() {
        User user = new User();
        user.login("987-6543", "password123");
        assertThat(user.getUsername(), is("987-6543"));
    }

    @Test
    public void shouldGetUserDetails() {
        User user = new User();
        user.createCustomer();
        assertThat(user.getName(), is ("Bob"));
        assertThat(user.getEmail(), is ("customer123@email.com"));
        assertThat(user.getAddress(), is ("1 Sydney St, Sydney"));
    }

    @Test
    public void shouldGetUserAccountType() {
        User user = new User();
        user.createCustomer();
        assertThat(user.getAccountType(), is ("customer"));
    }

    @Test
    public void shouldSetUserAttributesToNull() {
        User user = new User();
        user.createCustomer();
        user.logout();
        assertNull(user.getUsername());
        assertNull(user.getAccountType());
        assertNull(user.getName());
        assertNull(user.getAddress());
        assertNull(user.getEmail());
    }

}