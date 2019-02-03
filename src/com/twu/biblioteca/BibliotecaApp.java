package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static ArrayList<Book> listOfAvailableBooks = new ArrayList();
    public static ArrayList<Movie> listOfAvailableMovies = new ArrayList();

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        BookList listOfBooks = new BookList();
        listOfAvailableBooks = listOfBooks.getListOfBooks();

        MovieList listOfMovies = new MovieList();
        listOfAvailableMovies = listOfMovies.getListOfMovies();

        Menu menu = new Menu();
        menu.displayMenu();
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
