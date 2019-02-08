package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldBeAvailableToCheckoutMovieAtTimeOfCreation() {
        Movie movie = new Movie("This is a title", 1991, "This is the director", 7);
        assertThat(movie.isAvailable(), is(true));
    }

    @Test
    public void shouldBeAbleToCheckoutMovie() {
        Movie movie = new Movie("This is a title", 1991, "This is the director", 7);
        movie.checkout();
        assertThat(movie.isAvailable(), is(false));
    }

    @Test
    public void shouldNotBeAbleToCheckOutAnAlreadyCheckedOutMovie() {
        Movie movie = new Movie("This is a title", 1991, "This is the director", 7);
        movie.checkout();
        movie.checkout();
        assertThat(movie.isAvailable(), is(false));
    }



}