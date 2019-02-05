package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Book extends Story {

    public Book() {}

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void returnBook() {
        System.out.println("Please enter the title of the book you wish to return.");
        String bookToReturn = getUserInput();

        checkBookBelongsToLibrary(bookToReturn);
    }

    public void checkBookBelongsToLibrary(String book) {
        boolean doesBelong;
        boolean isCheckedOut;

        BookList bookList = new BookList();
        ArrayList<Book> listOfLibraryBooks = bookList.getListOfBooks();

        doesBelong = checkBookBelongs(book);
        isCheckedOut = checkBookIsCheckedOut(book);

        if(doesBelong == true && isCheckedOut == true) {
            for(Book b : listOfLibraryBooks) {
                if(b.getTitle().equalsIgnoreCase(book)) {
                    listOfAvailableBooks.add(b);
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

        for(Story s : listOfLibraryBooks) {
            if(s.getTitle().equalsIgnoreCase(book)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBookIsCheckedOut(String book) {
        ArrayList<String> listOfAvailableBookTitles = new ArrayList<>();

        for(Story s : listOfAvailableBooks) {
            listOfAvailableBookTitles.add(s.getTitle().toLowerCase());
        }

        if(listOfAvailableBookTitles.contains(book.toLowerCase())) {
            return false;
        }
        else {
            return true;
        }
    }
}