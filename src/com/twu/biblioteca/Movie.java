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

    public void checkoutMovie() {
        boolean isAvailable = true;
        System.out.println("Please enter the name of the movie you wish to checkout.");
        String movieToCheckout = getUserInput();

        for (int i = 0; i < listOfAvailableMovies.size(); i++) {
            if (listOfAvailableMovies.get(i).getTitle().equalsIgnoreCase(movieToCheckout)) {
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

        Story story = new Story();
        story.displayMenu();
    }
}
