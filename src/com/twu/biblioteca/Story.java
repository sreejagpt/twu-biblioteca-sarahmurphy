package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.BibliotecaApp.*;

public class Story {

    protected String title;
    protected int year;
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



    public void printList(ArrayList<? extends Story> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(printStory(list, i));
        }
    }

    public String printStory(ArrayList<? extends Story> list, int index) {
        String story = "";

        if(list.get(index) instanceof Book) {
            story = "Title: " + list.get(index).getTitle() + " | Author: " + list.get(index).getAuthor() +
                    " | Published: " + list.get(index).getYear();
        }
        if(list.get(index) instanceof Movie) {
            story = "Title: " + list.get(index).getTitle() + " | Year: " + list.get(index).getYear() +
                    " | Director: " + list.get(index).getDirector() + " | Rating: " + list.get(index).getRating();
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
