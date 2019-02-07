package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.listOfAvailableBooks;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {

    Library library = new Library();

    @Test
    public void shouldPrintListOfBooks() {
        ArrayList<Book> listOfBooks = library.getListOfBooks();

        Book book = new Book();

        for(int i = 0; i < listOfBooks.size(); i++) {
            //assertThat(book.printStory(listOfBooks, i), is(listOfBooks.get(i).getBook()));
        }
    }

    @Test
    public void shouldCheckIfBookToCheckOutIsAvailable() {
        listOfAvailableBooks = library.getListOfBooks();

        Book book = new Book();

        //assertThat(book.checkStoryIsAvailable("The Agile Samurai", listOfAvailableBooks), is(true));

    }

    @ Test
    public void shouldCheckIfBookBelongsToLibrary() {
        Book book = new Book();
        assertThat(book.checkBookBelongs("Head First Java"), is(true));
    }

    @ Test
    public void shouldCheckIfBookIsCheckedOut() {
        Book book = new Book();
        assertThat(book.checkBookIsCheckedOut("Checked Out Book"), is(true));
    }
}