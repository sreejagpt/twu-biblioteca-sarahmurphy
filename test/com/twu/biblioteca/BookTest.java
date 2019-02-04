package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldPrintListOfBooks() {
        BookList bookList = new BookList();
        ArrayList<Book> listOfBooks = bookList.getListOfBooks();

        Book book = new Book();

        for(int i = 0; i < listOfBooks.size(); i++) {
            assertThat(book.printBook(listOfBooks, i), is(listOfBooks.get(i).getBook()));
        }
    }
}