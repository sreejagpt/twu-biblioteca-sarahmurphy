package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<? extends Story> list;

    public Library() {}

    public Library(ArrayList<? extends Story> list) {
        this.list = list;
    }

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

    public Library createBookshelf() {
        return new Library(getListOfBooks());
    }

    public Library createMovieshelf() {
        return new Library(getListOfMovies());
    }

    public ArrayList<Book> bookshelf() {
        return getListOfBooks();
    }

    public ArrayList<Movie> movieshelf() {
        return getListOfMovies();
    }

    public void getAllBooks() {
        for(Book book : bookshelf()) {
            book.getBook();
        }
    }

    public void getAvailableBooks() {
        for (Book book : bookshelf()) {
            if(book.isAvailable()) {
                book.getBook();
            }
        }
    }



    //bookDatabase (all in/out)
    //bookShelf (available)
    //booksCheckedOut
}