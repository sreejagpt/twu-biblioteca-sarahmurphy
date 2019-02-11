package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Menu {

    public ArrayList<String> getMenu(User user) {
        ArrayList<String> menuOptions = new ArrayList<>();

        if(user.getUsername() == null) {
            menuOptions.add("1. View List of Books");
            menuOptions.add("2. View List of Movies");
            menuOptions.add("3. Login");
        } else if (user.getAccountType().equals("customer")) {
            addMenuOptions(menuOptions);
            menuOptions.add("6. View My Details");
            menuOptions.add("7. Logout");
        } else if (user.getAccountType().equals("librarian")) {
            addMenuOptions(menuOptions);
            menuOptions.add("6. View Checked Out Books");
            menuOptions.add("7. Logout");
        }

        return menuOptions;
    }

    public void addMenuOptions(ArrayList<String> menuOptions) {
        menuOptions.add("1. View List of Books");
        menuOptions.add("2. View List of Movies");
        menuOptions.add("3. Checkout a Book");
        menuOptions.add("4. Checkout a Movie");
        menuOptions.add("5. Return a Book");
    }

    public void displayMenu(User user, ArrayList<Book> bookshelf, ArrayList<Movie> movieshelf) {
        Menu menu = new Menu();
        ArrayList<String> menuOptions = menu.getMenu(user);

        System.out.println("\nMenu - please select an item from the list below (enter the item number) or type 'quit' to exit the application.");
        for (String s : menuOptions) {
            System.out.println(s);
        }

        String menuChoice = getUserInput();

        makeMenuChoice(menuChoice, user, bookshelf, movieshelf);
        displayMenu(user, bookshelf, movieshelf);
    }

    public void makeMenuChoice(String menuChoice, User user, ArrayList<Book> bookshelf, ArrayList<Movie> movieshelf) {
        if (menuChoice.equals("1")) {
            new Library().getAvailableBooks(bookshelf);
            return;
        }
        if (menuChoice.equals("2")) {
            new Library().getAvailableMovies(movieshelf);
            return;
        }
        if (menuChoice.equals("3")) {
            if(user.getUsername() == null) {
                user = login(user);
                return;
            } else{
                new Story().checkoutStory(bookshelf);
                return;
            }
        }
        if (menuChoice.equals("4")) {
            new Story().checkoutStory(movieshelf);
            return;
        }
        if (menuChoice.equals("5")) {
            new Book().returnBook(bookshelf);
            return;
        }
        if (menuChoice.equals("6")) {
            if(user.getAccountType().equals("customer")) {
                user.viewMyDetails();
            } else if(user.getAccountType().equals("librarian")) {
                new Book().viewCheckedOutBooks(bookshelf);
            }
            return;
        }
        if (menuChoice.equals("7")) {
            System.out.println("Goodbye");
            user.logout();
            return;
        }
        if (menuChoice.equalsIgnoreCase("quit")) {
            System.exit(0);
        } else {
            System.out.println("Please select a valid option! (Enter the item number)");
            String newChoice = getUserInput();
            makeMenuChoice(newChoice, user, bookshelf, movieshelf);
        }
    }

    public User login(User user) {
        System.out.println("Enter your Username: ");
        String username = getUserInput();

        System.out.println("Enter your password: ");
        String password = getUserInput();

        user.login(username, password);

        validateUser(user);

        return user;
    }

    public User validateUser(User user) {
        if(user.getUsername() != null) {
            System.out.println("Welcome " + user.getName());
        } else {
            System.out.println("That login is invalid");
        }
        return user;
    }

}
