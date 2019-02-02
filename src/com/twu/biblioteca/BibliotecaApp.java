package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        ArrayList<Book> listOfBooks = initialiseLibrary();

        printListOfBooks(listOfBooks);

    }

    public static ArrayList<Book> initialiseLibrary() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("The Agile Samurai", "Jonathon Rasmusson", 2010));
        listOfBooks.add(new Book("Test-Driven Development By Example", "Kent Beck", 2003));
        listOfBooks.add(new Book("Head First Java", "Kathy Sierra & Bert Bates", 2005));
        listOfBooks.add(new Book("Don’t Make Me Think Revisited", "Steve Krug", 2014));
        return listOfBooks;

    }

    public static void printListOfBooks(ArrayList<Book> listOfBooks) {
        System.out.println("Here is a list of books available in the library:");
        for (int i = 0; i<listOfBooks.size(); i++) {
            System.out.println(listOfBooks.get(i).getBook());
        }
    }
}
