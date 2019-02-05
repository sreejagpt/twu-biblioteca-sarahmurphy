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

    public void displayMenu() {
        Menu menu = new Menu();
        ArrayList<String> menuOptions = menu.getMenu();

        System.out.println("\n Menu - please select an item from the list below (enter the item number) or type 'quit' to exit the application.");
        for (String s : menuOptions) {
            System.out.println(s);
        }

        String menuChoice = getUserInput();

        menu.makeMenuChoice(menuChoice);
    }

    public void printList(ArrayList<? extends Story> list) {
        System.out.println("Here is a list of available books in the library:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(printStory(list, i));
        }

        displayMenu();
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

    public void checkoutStory() {
        boolean isAvailable = true;
        System.out.println("Please enter the title you wish to checkout.");
        String storyToCheckout = getUserInput();

        for (int i = 0; i < listOfAvailableBooks.size(); i++) {
            if (storyToCheckOutIsAvailable(i, storyToCheckout)) {
                isAvailable = true;
                listOfAvailableBooks.remove(i);
                System.out.println("Thank you! Enjoy!");
                break;
            } else {
                isAvailable = false;
            }
        }

        if(isAvailable == false) {
            System.out.println("Sorry, that title is not available");
        }

        displayMenu();
    }

    public boolean storyToCheckOutIsAvailable(int index, String storyToCheckout) {
        return listOfAvailableBooks.get(index).getTitle().equalsIgnoreCase(storyToCheckout);
    }

}
