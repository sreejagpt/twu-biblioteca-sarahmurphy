package com.twu.biblioteca;

public class User {

    private String username;
    private String password;
    private String accountType;
    private String name;
    private String email;
    private String address;

    User () {
        this.username = null;
        this.password = null;
    }

    User(String username, String password, String accountType, String name, String email, String address) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public User createCustomer() {
        this.username = "123-4567";
        this.password = "password123";
        this.accountType = "customer";
        this.name = "Bob";
        this.email = "customer123@email.com";
        this.address = "1 Sydney St, Sydney";
        return new User(username, password, accountType, name, email, address);
    }

    public User createLibrarian() {
        this.username = "987-6543";
        this.password = "password123";
        this.accountType = "librarian";
        this.name = "Kate";
        this.email = "librarian@email.com";
        this.address = "2 Harbour St, Sydney";
        return new User(username, password, accountType, name, email, address);
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public User login(String username, String password) {
        if (username.equals("123-4567") && password.equals("password123")) {
            return createCustomer();
        } else if (username.equals("987-6543") && password.equals("password123")) {
            return createLibrarian();
        }
        return new User();
    }

    public boolean isLoggedIn() {
        if(this.getUsername() != null) {
            return true;
        }
        return false;
    }

    public void logout() {
        this.username = null;
        this.password = null;
        this.accountType = null;
        this.name = null;
        this.email = null;
        this.address = null;
    }

    public void viewMyDetails() {
        System.out.println(this.getName());
        System.out.println(this.getEmail());
        System.out.println(this.getAddress());
    }



}
