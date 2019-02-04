package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldPrintListOfMovies() {
        MovieList listOfMovies = new MovieList();
        ArrayList<Movie> listOfAvailableMovies = listOfMovies.getListOfMovies();

        Movie printMovieList = new Movie();
        printMovieList.printListOfMovies(listOfAvailableMovies);

        //assertThat();
    }

    @Test
    public void shouldCheckoutMovie() {
        MovieList listOfMovies = new MovieList();
        ArrayList<Movie> listOfAvailableMovies = listOfMovies.getListOfMovies();

        Movie movie = new Movie();
        movie.checkoutMovie();

    }
}