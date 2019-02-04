package com.twu.biblioteca;

import java.util.ArrayList;

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

    public void printListOfBooks(ArrayList<Book> listOfBooks) {
        System.out.println("Here is a list of available books in the library:");
        for (int i = 0; i < listOfBooks.size(); i++) {
            System.out.println(printBook(listOfBooks, i));
        }

        Menu menu = new Menu();
        menu.displayMenu();
    }

    public String printBook(ArrayList<Book> listOfBooks, int index) {
        String book = listOfBooks.get(index).getBook();
        return book;
    }

    public void checkoutBook() {
        boolean isAvailable = true;
        System.out.println("Please enter the title of the book you wish to checkout.");
        String bookToCheckout = getUserInput();

        for (int i = 0; i < listOfAvailableBooks.size(); i++) {
            if (bookToCheckOutIsAvailable(i, bookToCheckout)) {
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
        Menu menu = new Menu();
        menu.displayMenu();
    }

    public boolean bookToCheckOutIsAvailable(int index, String bookToCheckout) {
        return listOfAvailableBooks.get(index).getTitle().equalsIgnoreCase(bookToCheckout);
    }

    public void returnBook() {
        System.out.println("Please enter the title of the book you wish to return.");
        String bookToReturn = getUserInput();

        checkBookBelongsToLibrary(bookToReturn);

        Menu menu = new Menu();
        menu.displayMenu();
    }

    public void checkBookBelongsToLibrary(String book) {
        boolean doesBelong;
        boolean isCheckedOut;

        BookList bookList = new BookList();
        ArrayList<Book> listOfLibraryBooks = bookList.getListOfBooks();

        doesBelong = checkBookBelongs(book);
        isCheckedOut = checkBookIsCheckedOut(book);

        if(doesBelong == true && isCheckedOut == true) {
            for(Book b1 : listOfLibraryBooks) {
                if(b1.getTitle().equalsIgnoreCase(book)) {
                    listOfAvailableBooks.add(b1);
                }
            }
            System.out.println("Thank you for returning the book.");
        }
        else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public boolean checkBookBelongs(String book) {
        BookList bookList = new BookList();
        ArrayList<Book> listOfLibraryBooks = bookList.getListOfBooks();

        for(Book b1 : listOfLibraryBooks) {
            if(b1.getTitle().equalsIgnoreCase(book)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBookIsCheckedOut(String book) {
        ArrayList<String> listOfAvailableBookTitles = new ArrayList<>();

        for(Book b : listOfAvailableBooks) {
            listOfAvailableBookTitles.add(b.getTitle().toLowerCase());
        }

        if(listOfAvailableBookTitles.contains(book.toLowerCase())) {
            return false;
        }
        else {
            return true;
        }
    }
}