package com.twu.biblioteca;

public class Book extends LibraryItem {

    private String author;

    Book(String title, int year, int rating, String author) {
        super(title, year, rating);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return super.toString() +
                "author='" + author + '\n';
    }
}