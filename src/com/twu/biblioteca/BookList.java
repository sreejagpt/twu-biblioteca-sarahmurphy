package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {

    public ArrayList<Book> getListOfBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("The Agile Samurai", "Jonathon Rasmusson", 2010));
        listOfBooks.add(new Book("Test-Driven Development By Example", "Kent Beck", 2003));
        listOfBooks.add(new Book("Head First Java", "Kathy Sierra & Bert Bates", 2005));
        listOfBooks.add(new Book("Don’t Make Me Think Revisited", "Steve Krug", 2014));
        return listOfBooks;
    }
}