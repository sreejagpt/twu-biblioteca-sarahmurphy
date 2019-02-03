package com.twu.biblioteca;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Book {

    public String title;
    public String author;
    public int year;

    public Book() {

    }

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

    public void checkoutBook() {
        boolean isAvailable = true;
        System.out.println("Please enter the title of the book you wish to checkout.");
        String bookToCheckout = getUserInput();

        for (int i = 0; i < listOfAvailableBooks.size(); i++) {
            if (listOfAvailableBooks.get(i).getTitle().equalsIgnoreCase(bookToCheckout)) {
                isAvailable = true;
                listOfAvailableBooks.remove(i);
                System.out.println("Thank you! Enjoy the book");
                break;
            } else {
                isAvailable = false;
            }
        }

        if(isAvailable == false) {
            System.out.println("Sorry, that book is not available");
        }
        displayMenu();
    }
}