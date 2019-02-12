package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldHaveTitleDirectorAndYear() {
        Movie movie = new Movie("This is a title", 1991, 10,"This is the director");
        assertThat(movie.toString(), is("title='This is a title', year=1991, isAvailable=true, rating=10\n" +
                " director='This is the director\n"));
    }

    @Test
    public void shouldBeAvailableToCheckoutAtTimeOfCreation() {
        Movie movie = new Movie("This is a title", 1991, 10,"This is the director");
        assertThat(movie.isAvailable(), is(true));
    }

    @Test
    public void shouldBeAbleToCheckoutMovie() {
        Movie movie = new Movie("This is a title", 1991, 10,"This is the director");
        movie.checkout();
        assertThat(movie.isAvailable(), is(false));
    }

    @Test
    public void shouldNotBeAbleToCheckOutAnAlreadyCheckedOutMovie() {
        Movie movie = new Movie("This is a title", 1991, 10,"This is the director");
        movie.checkout();
        movie.checkout();
        assertThat(movie.isAvailable(), is(false));
    }

    @Test
    public void shouldBeAbleToReturnACheckedOutMovie() {
        Movie movie = new Movie("This is a title", 1991, 10,"This is the director");
        movie.checkout();
        movie.checkIn();
        assertThat(movie.isAvailable(), is(true));
    }

    @Test
    public void shouldNotBeAbleToReturnACheckedInMovie() {
        Movie movie = new Movie("This is a title", 1991, 10,"This is the director");
        movie.checkIn();
        assertThat(movie.isAvailable(), is(true));
    }

    @Test
    public void shouldCheckIfMovieIsCheckedOut() {
        Movie movie = new Movie("This is a title", 1991, 10,"This is the director");
        movie.checkout();
        assertThat(movie.isAvailable(), is(false));
    }



}