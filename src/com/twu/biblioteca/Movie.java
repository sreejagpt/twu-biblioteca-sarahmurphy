package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Movie extends Story {

    public Movie() {}

    public Movie(String title, int year, String director, int rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }
}
