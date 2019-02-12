package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Menu {
    //TODO use LibraryItem instead of Book or Movie in this code, and try TDD

    public List<String> getMenu(User user) {
        ArrayList<String> menuOptions = new ArrayList<>();

        if(user.getUsername() == null) {
            addLoggedOutMenuOptions(menuOptions);
        } else {
            addLoggedInMenuOptions(user, menuOptions);
        }

        return menuOptions;
    }

    public void addLoggedOutMenuOptions(ArrayList<String> menuOptions) {
        menuOptions.add("1. View List of Books");
        menuOptions.add("2. View List of Movies");
        menuOptions.add("3. Login");
    }

    public void addLoggedInMenuOptions(User user, ArrayList<String> menuOptions) {
        menuOptions.add("1. View List of Books");
        menuOptions.add("2. View List of Movies");
        menuOptions.add("3. Checkout a Book");
        menuOptions.add("4. Checkout a Movie");
        menuOptions.add("5. Return a Book");

        if(user.getAccountType().equals("customer")) {
            menuOptions.add("6. View My Details");
        }
        if (user.getAccountType().equals("librarian")) {
            menuOptions.add("6. View Checked Out Books");
        }

        menuOptions.add("7. Logout");
    }

    public void displayMenu(User user, List<LibraryItem> libraryItems) {
        getMenuOptions(user);

        String menuChoice = getUserInput();
        makeMenuChoice(menuChoice, user, libraryItems);

        displayMenu(user, libraryItems);
    }

    public void getMenuOptions(User user) {
        Menu menu = new Menu();
        List<String> menuOptions = menu.getMenu(user);

        System.out.println("\nMenu - please select an item from the list below (enter the item number) or type 'quit' to exit the application.");
        for (String s : menuOptions) {
            System.out.println(s);
        }
    }

    public void makeMenuChoice(String menuChoice, User user, List<LibraryItem> libraryItems) {
        switch(menuChoice) {
//            case "1":
//                new Library().getAvailableItems(libraryItems);
//                return;
//            case "3":
//                checkLoggedIn(user, libraryItems); //incomplete
//                return;
//            case "4":
//                new LibraryItem().checkoutStory(movieshelf);
//                return;
//            case "5":
//                new Book().returnBook(bookshelf);
//                return;
//            case "6":
//                checkAccountType(user, bookshelf);
//                return;
//            case "7":
//                logout(user);
//                return;
//            case "quit":
//                quitProgram();
//                return;
//            default:
//                menuChoiceErrorMessage(user, bookshelf, movieshelf);
        }
    }

    public void menuChoiceErrorMessage(User user, ArrayList<Book> bookshelf, ArrayList<Movie> movieshelf) {
        System.out.println("Please select a valid option! (Enter the item number)");
        String newChoice = getUserInput();
//        makeMenuChoice(newChoice, user, bookshelf, movieshelf);
    }

    public User checkLoggedIn(User user, List<Book> bookshelf) {
        if(!user.isLoggedIn()) {
            user = login(user);
            return user;
        } else {
//            new LibraryItem().checkoutStory(bookshelf);
        }
        return user;
    }

    public void checkAccountType(User user, ArrayList<Book> bookshelf) {
        if(user.getAccountType().equals("customer")) {
            user.viewMyDetails();
        } else if(user.getAccountType().equals("librarian")) {
//            new Book().viewCheckedOutBooks(bookshelf);
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

    public void logout(User user) {
        System.out.println("Goodbye");
        user.logout();
    }

    public void quitProgram() {
        System.exit(0);
    }

}
