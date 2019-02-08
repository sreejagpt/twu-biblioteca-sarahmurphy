package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldHaveTitleAuthorAndYear() {
        Book book = new Book("This is a title", "This is the author", 1991);
        assertThat(book.getBook(), is("Title: This is a title | Author: This is the author | Published: 1991"));
    }

    //think about what you can do with a book, write little one liner tests ^ to 1) fail first, 2) go green next 3) refactor

    @Test
    public void shouldBeAvailableToCheckoutAtTimeOfCreation() {
        Book book = new Book("This is a title", "This is the author", 1991);
        assertThat(book.isAvailable(), is(true));
    }

    @Test
    public void shouldBeAbleToCheckoutBook() {
        Book book = new Book("This is a title", "This is the author", 1991);
        book.checkout();
        assertThat(book.isAvailable(), is(false));
    }

    @Test
    public void shouldNotBeAbleToCheckOutAnAlreadyCheckedOutBook() {
        Book book = new Book("This is a title", "This is the author", 1991);
        book.checkout();
        book.checkout();
        assertThat(book.isAvailable(), is(false));
    }

    @Test
    public void shouldBeAbleToReturnACheckedOutBook() {
        Book book = new Book("This is a title", "This is the author", 1991);
        book.checkout();
        book.returnItem();
        assertThat(book.isAvailable(), is(true));
    }

    @Test
    public void shouldNotBeAbleToReturnACheckedInBook() {
        Book book = new Book("This is a title", "This is the author", 1991);
        book.returnItem();
        assertThat(book.isAvailable(), is(true));
    }

    @Test
    public void shouldCheckIfBookIsCheckedOut() {
        Book book = new Book("This is a title", "This is the author", 1991);
        book.checkout();
        assertThat(book.isAvailable(), is(false));
    }
}