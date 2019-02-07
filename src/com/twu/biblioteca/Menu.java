package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Menu {

    public ArrayList<String> getMenu() {
        ArrayList<String> menuOptions = new ArrayList<>();

        if(user.getUsername() == null) {
            menuOptions.add("1. View List of Books");
            menuOptions.add("2. View List of Movies");
            menuOptions.add("3. Login");
        } else if (user.getAccountType().equals("customer")) {
            addMenuOptions(menuOptions);
            menuOptions.add("6. View My Details");
        } else if (user.getAccountType().equals("librarian")) {
            addMenuOptions(menuOptions);
            menuOptions.add("6. View Checked Out Books");
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

    public void displayMenu() {
        Menu menu = new Menu();
        ArrayList<String> menuOptions = menu.getMenu();

        System.out.println("\n Menu - please select an item from the list below (enter the item number) or type 'quit' to exit the application.");
        for (String s : menuOptions) {
            System.out.println(s);
        }

        String menuChoice = getUserInput();

        makeMenuChoice(menuChoice);
        displayMenu();
    }

    public void makeMenuChoice(String menuChoice) {
        if (menuChoice.equals("1")) {
            Book printBookList = new Book();
            printBookList.printList(listOfAvailableBooks);
            return;
        }
        if (menuChoice.equals("2")) {
            Movie printMovieList = new Movie();
            printMovieList.printList(listOfAvailableMovies);
            return;
        }
        if (menuChoice.equals("3")) {
            if(user.getUsername() == null) {
                login();
                return;
            } else{
                new Story().checkoutStory(listOfAvailableBooks);
                return;
            }
        }
        if (menuChoice.equals("4")) {
            Movie checkoutMovie = new Movie();
            checkoutMovie.checkoutStory(listOfAvailableMovies);
            return;
        }
        if (menuChoice.equals("5")) {
            Book returnBook = new Book();
            returnBook.returnBook();
            return;
        }
        if (menuChoice.equals("6")) {
            if(user.getAccountType().equals("customer")) {
                user.viewMyDetails(user);
            } else if(user.getAccountType().equals("librarian")) {
                new Book().viewCheckedOutBooks();
            }
            return;
        }
        if (menuChoice.equalsIgnoreCase("quit")) {
            System.exit(0);
        } else {
            System.out.println("Please select a valid option! (Enter the item number)");
            String newChoice = getUserInput();
            makeMenuChoice(newChoice);
        }
    }

    public void login() {
        System.out.println("Enter your Username: ");
        String username = getUserInput();

        System.out.println("Enter your password: ");
        String password = getUserInput();

        user = user.login(username, password);

        if(user.getUsername() != null) {
            System.out.println("Welcome " + user.getName());
        } else {
            System.out.println("That login is invalid");
        }
    }

}
