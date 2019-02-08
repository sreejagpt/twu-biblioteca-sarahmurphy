package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<? extends Story> list;

    public Library() {}

    public ArrayList<Book> getListOfBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("The Agile Samurai", "Jonathon Rasmusson", 2010));
        listOfBooks.add(new Book("Test-Driven Development By Example", "Kent Beck", 2003));
        listOfBooks.add(new Book("Head First Java", "Kathy Sierra & Bert Bates", 2005));
        listOfBooks.add(new Book("Don’t Make Me Think Revisited", "Steve Krug", 2014));
        return listOfBooks;
    }

    public ArrayList<Movie> getListOfMovies() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        listOfMovies.add(new Movie("First Man", 2018, "Damien Chazelle", 7));
        listOfMovies.add(new Movie("Rush", 2013, "Ron Howard", 8));
        listOfMovies.add(new Movie("After Earth", 2013, "M. Night Shyamalan", 4));
        listOfMovies.add(new Movie("Shrek", 2001, "Andrew Adamson & Vicky Jenson", 8));
        return listOfMovies;
    }

    public ArrayList<Book> createBookshelf() {
        return getListOfBooks();
    }

    public ArrayList<Movie> createMovieshelf() {
        return getListOfMovies();
    }

    public void getAvailableBooks(ArrayList<Book> bookshelf) {
        for (Book book : bookshelf) {
            if(book.isAvailable()) {
                System.out.println(book.getBook());
            }
        }
    }

    public void getAvailableMovies(ArrayList<Movie> movieshelf) {
        for (Movie movie : movieshelf) {
            if(movie.isAvailable()) {
                System.out.println(movie.getMovie());
            }
        }
    }
}