package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    //TODO tests for this class

    private static List<LibraryItem> libraryItems = new ArrayList<LibraryItem>() {
        {
            add(new Book("Harry Potter", 1997, 25, "J.K Rowling"));
            add(new Movie("Roma", 2019, 27, "Alfonso Cuaron"));
        }
    };

    public List<LibraryItem> getAvailableItems() {
        List<LibraryItem> availableItems = new ArrayList<>();
        for (LibraryItem libraryItem : libraryItems) {
            if(libraryItem.isAvailable()) {
                availableItems.add(libraryItem);
            }
        }
        return availableItems;
    }
}