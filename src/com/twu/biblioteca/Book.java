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

    public String getBook() {
        return "Title: " + getTitle() + " | Author: " + getAuthor() +
                " | Published: " + getYear();
    }

    public void returnBook() {
        System.out.println("Please enter the title of the book you wish to return.");
        String bookToReturn = getUserInput();

        checkBookBelongsToLibrary(bookToReturn);
    }

    public void checkBookBelongsToLibrary(String book) {
        boolean doesBelong;
        boolean isCheckedOut;

        doesBelong = checkBookBelongs(book);
        isCheckedOut = checkBookIsCheckedOut(book);

        if(doesBelong && isCheckedOut) {
            returnBookToLibrary(book);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public void returnBookToLibrary(String book) {
        BookList bookList = new BookList();
        ArrayList<Book> listOfLibraryBooks = bookList.getListOfBooks();

        // Gets all details of book to add back to library list
        for(Book b : listOfLibraryBooks) {
            if(b.getTitle().equalsIgnoreCase(book)) {
                listOfAvailableBooks.add(b);
            }
        }
        System.out.println("Thank you for returning the book.");

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
        } else {
            return true;
        }
    }

    public void viewCheckedOutBooks() {

        ArrayList<Book> checkedOutBooks = new ArrayList<>();

        checkedOutBooks = getCheckedOutBooks(checkedOutBooks);

        printCheckedOutBooks(checkedOutBooks);

    }

    public ArrayList<Book> getCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
        BookList bookList = new BookList();
        ArrayList<Book> listOfLibraryBooks = bookList.getListOfBooks();

        listOfAvailableBooks.remove(1);

        if(!listOfLibraryBooks.equals(listOfAvailableBooks)) {
            //get list here
        }
        return checkedOutBooks;
    }

    public void printCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
        if(!checkedOutBooks.isEmpty()) {
            System.out.println("Checked Out Books:");
            printList(checkedOutBooks);
        } else {
            System.out.println("No books are checked out");
        }
    }


}