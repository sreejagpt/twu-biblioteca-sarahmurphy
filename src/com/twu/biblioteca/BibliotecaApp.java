package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static ArrayList<Book> listOfAvailableBooks = new ArrayList();
    public static ArrayList<Movie> listOfAvailableMovies = new ArrayList();
    public static User user = new User();

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        Library listOfBooks = new Library();
        listOfAvailableBooks = listOfBooks.getListOfBooks();

        Library listOfMovies = new Library();
        listOfAvailableMovies = listOfMovies.getListOfMovies();

        User user = new User();
        user.createCustomer();
        user.createLibrarian();

        Menu menu = new Menu();
        menu.displayMenu();
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
