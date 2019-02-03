package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldPrintListOfMovies() {
        MovieList listOfMovies = new MovieList();
        ArrayList<Movie> listOfAvailableMovies = listOfMovies.getListOfMovies();

        Movie printMovieList = new Movie();
        printMovieList.printListOfMovies(listOfAvailableMovies);

        //assertThat();
    }
}