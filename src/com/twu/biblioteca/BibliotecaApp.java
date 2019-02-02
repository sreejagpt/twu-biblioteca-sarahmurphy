package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static ArrayList<Book> listOfBooks = new ArrayList<Book>();

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        listOfBooks = initialiseLibrary();
        displayMenu();

    }

    public static ArrayList<Book> initialiseLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("The Agile Samurai", "Jonathon Rasmusson", 2010));
        listOfBooks.add(new Book("Test-Driven Development By Example", "Kent Beck", 2003));
        listOfBooks.add(new Book("Head First Java", "Kathy Sierra & Bert Bates", 2005));
        listOfBooks.add(new Book("Don’t Make Me Think Revisited", "Steve Krug", 2014));
        return listOfBooks;
    }

    public static ArrayList<String> initialiseMenu() {
        ArrayList<String> menuOptions = new ArrayList<String>();
        menuOptions.add("1. View List of Books");
        return menuOptions;
    }

    public static void displayMenu(){
        ArrayList<String> menuOptions = initialiseMenu();

        System.out.println("Menu");
        for(String s : menuOptions) {
            System.out.println(s);
        }

        System.out.println("Please select a menu item from above (enter the item number) or type 'quit' to exit the application.");
        String menuChoice = getUserInput();

        makeMenuChoice(menuChoice);
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        return userInput;
    }

    public static void makeMenuChoice(String menuChoice) {
        if(menuChoice.equals("1")) {
            printListOfBooks(listOfBooks);
            return;
        }
        if(menuChoice.equalsIgnoreCase("quit")) {
            System.exit(0);
        }
        else {
            System.out.println("Please select a valid option! (Enter the item number)");
            String newChoice = getUserInput();
            makeMenuChoice(newChoice);
        }
    }

    public static void printListOfBooks(ArrayList<Book> listOfBooks) {
        System.out.println("Here is a list of books in the library:");
        for (int i = 0; i<listOfBooks.size(); i++) {
            System.out.println(listOfBooks.get(i).getBook());
        }
    }
}
