package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static ArrayList<Book> listOfAvailableBooks = new ArrayList();

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        BookList listOfBooks = new BookList();
        listOfAvailableBooks = listOfBooks.getListOfBooks();

        displayMenu();

    }

    public static void displayMenu() {
        Menu menu = new Menu();
        ArrayList<String> menuOptions = menu.getMenu();

        System.out.println("\n Menu - please select an item from the list below (enter the item number) or type 'quit' to exit the application.");
        for (String s : menuOptions) {
            System.out.println(s);
        }

        String menuChoice = getUserInput();

        makeMenuChoice(menuChoice);
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void makeMenuChoice(String menuChoice) {
        if (menuChoice.equals("1")) {
            printListOfBooks(listOfAvailableBooks);
            return;
        }
        if (menuChoice.equals("2")) {
            Book checkoutBook = new Book();
            checkoutBook.checkoutBook();

            //checkoutBook();
            return;
        }
        if (menuChoice.equals("3")) {
            returnBook();
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

    public static void printListOfBooks(ArrayList<Book> listOfBooks) {
        System.out.println("Here is a list of available books in the library:");
        for (int i = 0; i < listOfBooks.size(); i++) {
            System.out.println(listOfBooks.get(i).getBook());
        }
        displayMenu();
    }

    public static void returnBook() {
        System.out.println("Please enter the title of the book you wish to return.");
        String bookToReturn = getUserInput();

        checkBookBelongsToLibrary(bookToReturn);

        displayMenu();
    }

    public static void checkBookBelongsToLibrary(String book) {
        boolean doesBelong;
        boolean isCheckedOut;

        BookList bookList = new BookList();
        ArrayList<Book> listOfLibraryBooks = bookList.getListOfBooks();

        isCheckedOut = checkBookIsCheckedOut(book);
        doesBelong = checkBookBelongs(book);

        if(doesBelong == true && isCheckedOut == true) {
            for(Book b1 : listOfLibraryBooks) {
                if(b1.getTitle().equalsIgnoreCase(book)) {
                    listOfAvailableBooks.add(b1);
                }
            }
            System.out.println("Thank you for returning the book.");
        }
        else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public static boolean checkBookBelongs(String book) {
        BookList bookList = new BookList();
        ArrayList<Book> listOfLibraryBooks = bookList.getListOfBooks();

        for(Book b1 : listOfLibraryBooks) {
            if(b1.getTitle().equalsIgnoreCase(book)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkBookIsCheckedOut(String book) {
        ArrayList<String> listOfAvailableBookTitles = new ArrayList<>();

        for(Book b : listOfAvailableBooks) {
            listOfAvailableBookTitles.add(b.getTitle().toLowerCase());
        }

        if(listOfAvailableBookTitles.contains(book.toLowerCase())) {
            return false;
        }
        else {
            return true;
        }
    }
}
