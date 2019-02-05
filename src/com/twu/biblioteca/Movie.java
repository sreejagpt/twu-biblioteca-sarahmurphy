package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

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

        Book book = new Book();
        book.displayMenu();
    }

    public void checkoutMovie() {
        boolean isAvailable = true;
        System.out.println("Please enter the name of the movie you wish to checkout.");
        String movieToCheckout = getUserInput();

        for (int i = 0; i < listOfAvailableMovies.size(); i++) {
            if (listOfAvailableMovies.get(i).getName().equalsIgnoreCase(movieToCheckout)) {
                isAvailable = true;
                listOfAvailableMovies.remove(i);
                System.out.println("Thank you! Enjoy the movie");
                break;
            } else {
                isAvailable = false;
            }
        }

        if(isAvailable == false) {
            System.out.println("Sorry, that movie is not available");
        }

        Book book = new Book();
        book.displayMenu();
    }
}
