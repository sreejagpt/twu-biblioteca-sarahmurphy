package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldHaveTitleAuthorAndYear() {
        Book book = new Book("This is a title", 1991, 10,"This is the author");
        assertThat(book.toString(), is("title='This is a title', year=1991, isAvailable=true, rating=10\nauthor='This is the author\n"));
    }

    @Test
    public void shouldBeAvailableToCheckoutAtTimeOfCreation() {
        Book book = new Book("This is a title", 1991, 10,"This is the author");
        assertThat(book.isAvailable(), is(true));
    }

    @Test
    public void shouldBeAbleToCheckoutBook() {
        Book book = new Book("This is a title", 1991, 10,"This is the author");
        book.checkout();
        assertThat(book.isAvailable(), is(false));
    }

    @Test
    public void shouldNotBeAbleToCheckOutAnAlreadyCheckedOutBook() {
        Book book = new Book("This is a title", 1991, 10,"This is the author");
        book.checkout();
        book.checkout();
        assertThat(book.isAvailable(), is(false));
    }

    @Test
    public void shouldBeAbleToReturnACheckedOutBook() {
        Book book = new Book("This is a title", 1991, 10,"This is the author");
        book.checkout();
        book.checkIn();
        assertThat(book.isAvailable(), is(true));
    }

    @Test
    public void shouldNotBeAbleToReturnACheckedInBook() {
        Book book = new Book("This is a title", 1991, 10,"This is the author");
        book.checkIn();
        assertThat(book.isAvailable(), is(true));
    }

    @Test
    public void shouldCheckIfBookIsCheckedOut() {
        Book book = new Book("This is a title", 1991, 10,"This is the author");
        book.checkout();
        assertThat(book.isAvailable(), is(false));
    }
}