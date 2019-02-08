package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static User user = new User();

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        Library library = new Library();
        ArrayList<Book> bookshelf = library.createBookshelf();
        ArrayList<Movie> movieshelf = library.createMovieshelf();

        Menu menu = new Menu();
        menu.displayMenu(bookshelf, movieshelf);
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
