package com.twu.biblioteca;

import java.util.ArrayList;

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

    public void printListOfMovies(ArrayList<Movie> listOfMovies) {
        System.out.println("Here is a list of available movies in the library:");
        for (int i = 0; i < listOfMovies.size(); i++) {
            System.out.println(listOfMovies.get(i).getMovie());
        }

        Menu menu = new Menu();
        menu.displayMenu();
    }
}
