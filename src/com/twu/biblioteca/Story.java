package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Story {

    protected String title;
    protected int year;
    protected boolean isAvailable;
    protected String author;
    protected String director;
    protected int rating;

    public Story() {

    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }


    public void checkoutStory(ArrayList<? extends Story> list) {
        System.out.println("Please enter the title you wish to checkout.");
        String storyToCheckout = getUserInput();

        for (int i = 0; i < list.size(); i++) {
            Story storyInList = list.get(i);
            if (storyInList.getTitle().equalsIgnoreCase(storyToCheckout)) {
                if(storyInList.isAvailable()) {
                    storyInList.checkout();
                    System.out.println("Thank you! Enjoy!");
                    return;
                }
            }
        }
        System.out.println("Sorry, that title is not available");
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void checkout() {
        if(this.isAvailable) {
            this.isAvailable = false;
        }
    }

}
