package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Story {

    public String title;
    public int year;
    public String author;
    public String director;
    public int rating;

    public Story() {

    }

    public String getTitle() {
        return title;
    }

    public void printList(ArrayList<? extends Story> list) {
        System.out.println("Here is a list of available books in the library:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(printStory(list, i));
        }
    }

    public String printStory(ArrayList<? extends Story> list, int index) {
        String story = "";

        if(list.get(index) instanceof Book) {
            story = "Title: " + ((Book) list.get(index)).title + " | Author: " + ((Book) list.get(index)).author +
                    " | Published: " + ((Book) list.get(index)).year;
        }
        if(list.get(index) instanceof Movie) {
            story = "Title: " + ((Movie) list.get(index)).title + " | Year: " + ((Movie) list.get(index)).year +
                    " | Director: " + ((Movie) list.get(index)).director + " | Rating: " + ((Movie) list.get(index)).rating;
        }

        return story;
    }

    public void checkoutStory(ArrayList<? extends Story> list) {
        System.out.println("Please enter the title you wish to checkout.");
        String storyToCheckout = getUserInput();

        checkStoryIsAvailable(storyToCheckout, list);
    }

    public void checkStoryIsAvailable(String storyToCheckout, ArrayList<? extends Story> list) {
        boolean isAvailable = true;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equalsIgnoreCase(storyToCheckout)) {
                isAvailable = true;
                checkoutOutStory(i, list);
                break;
            } else {
                isAvailable = false;
            }
        }

        if(!isAvailable) {
            printUnavailableMessage();
        }

    }

    public void checkoutOutStory(int index, ArrayList<? extends Story> list) {
        list.remove(index);
        System.out.println("Thank you! Enjoy!");
    }

    public void printUnavailableMessage() {
        System.out.println("Sorry, that title is not available");
    }

}
