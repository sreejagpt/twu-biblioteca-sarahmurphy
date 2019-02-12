package com.twu.biblioteca;

public class Movie extends LibraryItem {
    private String director;

    Movie(String title, int year, int rating, String director) {
        super(title, year, rating);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return super.toString() +
                " director='" + director + '\n';
    }
}
