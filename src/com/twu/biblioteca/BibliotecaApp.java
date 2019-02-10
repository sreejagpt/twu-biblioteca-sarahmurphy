package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        Library library = new Library();
        ArrayList<Book> bookshelf = library.createBookshelf();
        ArrayList<Movie> movieshelf = library.createMovieshelf();

        User user = new User();

        Menu menu = new Menu();
        menu.displayMenu(user, bookshelf, movieshelf);
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
