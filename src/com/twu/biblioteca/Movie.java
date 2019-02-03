package com.twu.biblioteca;

public class Movie {

    public String name;
    public int year;
    public String director;
    public int rating;

    public Movie() {

    }

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getMovie() {
        return "Name: " + name + " | Year: " + year + " | Director: " + director + " | Rating: " + rating;
    }

    public String getName() {
        return name;
    }
}
