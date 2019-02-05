package com.twu.biblioteca;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.listOfAvailableBooks;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {

    BookList bookList = new BookList();

    @Test
    public void shouldPrintListOfBooks() {
        ArrayList<Book> listOfBooks = bookList.getListOfBooks();

        Book book = new Book();

        for(int i = 0; i < listOfBooks.size(); i++) {
            //assertThat(book.printStory(listOfBooks, i), is(listOfBooks.get(i).getBook()));
        }
    }

    @Test
    public void shouldCheckIfBookToCheckOutIsAvailable() {
        listOfAvailableBooks = bookList.getListOfBooks();

        Book book = new Book();

        //assertThat(book.checkStoryIsAvailable("The Agile Samurai", listOfAvailableBooks), is(true));

    }
}