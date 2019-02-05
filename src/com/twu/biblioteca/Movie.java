package com.twu.biblioteca;

public class Movie extends Story {

    public Movie() {}

    public Movie(String title, int year, String director, int rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }
}
