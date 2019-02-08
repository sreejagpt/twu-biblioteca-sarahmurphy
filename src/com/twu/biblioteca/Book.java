package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Book extends Story {

    public Book() {}

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    public String getBook() {
        return "Title: " + getTitle() + " | Author: " + getAuthor() +
                " | Published: " + getYear();
    }

    public void returnBook(ArrayList<Book> bookshelf) {
        System.out.println("Please enter the title of the book you wish to return.");
        String book = getUserInput();

        Library library = new Library();
        ArrayList<Book> list = library.createBookshelf();

        for(Book b : list) {
            if(b.getTitle().equalsIgnoreCase(book)) {
                for(Book c : bookshelf) {
                    if(c.getTitle().equalsIgnoreCase(book)) {
                        c.returnItem();
                    }
                }
            }
        }
    }

    public void returnItem() {
        if(!this.isAvailable()) {
            this.isAvailable = true;
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public void viewCheckedOutBooks(ArrayList<Book> bookshelf) {
        for(int i = 0; i < bookshelf.size(); i++) {
            Book book = bookshelf.get(i);
            if(!book.isAvailable()) {
                System.out.println(book.getBook());
            }
        }
    }

}