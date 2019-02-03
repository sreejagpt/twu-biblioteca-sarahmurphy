package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Menu {

    public ArrayList<String> getMenu() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1. View List of Books");
        menuOptions.add("2. Checkout a Book");
        menuOptions.add("3. Return a Book");
        return menuOptions;
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
    }

    public void makeMenuChoice(String menuChoice) {
        if (menuChoice.equals("1")) {
            printListOfBooks(listOfAvailableBooks);
            return;
        }
        if (menuChoice.equals("2")) {
            Book checkoutBook = new Book();
            checkoutBook.checkoutBook();
            return;
        }
        if (menuChoice.equals("3")) {
            Book returnBook = new Book();
            returnBook.returnBook();
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

}
