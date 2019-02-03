package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList {

    public ArrayList<Movie> getListOfMovies() {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        listOfMovies.add(new Movie("First Man", 2018, "Damien Chazelle", 7));
        listOfMovies.add(new Movie("Rush", 2013, "Ron Howard", 8));
        listOfMovies.add(new Movie("After Earth", 2013, "M. Night Shyamalan", 4));
        listOfMovies.add(new Movie("Shrek", 2001, "Andrew Adamson & Vicky Jenson", 8));

        return listOfMovies;
    }
}