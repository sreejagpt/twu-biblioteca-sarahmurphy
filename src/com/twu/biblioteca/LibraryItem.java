package com.twu.biblioteca;

import java.util.Date;

public class LibraryItem {

    private String title;
    private int year;
    private boolean isAvailable;
    private int rating;

    LibraryItem(String title, int year, int rating) {
        this.title = title;
        this.year = year;
        this.isAvailable = true;
        this.rating = rating;
    }

    boolean isAvailable() {
        return this.isAvailable;
    }

    void checkout() {
        this.isAvailable = false;
    }

    void checkIn() {
        this.isAvailable = true;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", year=" + year +
                ", isAvailable=" + isAvailable +
                ", rating=" + rating + '\n';
    }
}
