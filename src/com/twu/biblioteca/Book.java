package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Book {

    public String title;
    public String author;
    public int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getBook() {
        return "Title: " + title + " | Author: " + author + " | Published: " + year;
    }

    public String getTitle() {
        return title;
    }
}