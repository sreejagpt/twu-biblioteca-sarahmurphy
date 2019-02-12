package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryItemTest {
    @Test
    public void shouldBeInitialisedWithInformation() {
        LibraryItem item = new LibraryItem("Title", 1997, 10);
        assertThat(item.getRating(), is(10));
        assertThat(item.getTitle(), is("Title"));
        assertThat(item.getYear(), is(1997));
        assertThat(item.isAvailable(), is(true));
    }

    @Test
    public void shouldBeAbleToCheckoutLibraryItemAndMakeItUnavailable() {
        LibraryItem item = new LibraryItem("Title", 1997, 10);
        assertThat(item.isAvailable(), is(true));

        item.checkout();

        assertThat(item.isAvailable(), is(false));
    }


    @Test
    public void shouldBeAbleToCheckInItem() {
        LibraryItem item = new LibraryItem("Title", 1997, 10);
        assertThat(item.isAvailable(), is(true));

        item.checkout();

        assertThat(item.isAvailable(), is(false));

        item.checkIn();

        assertThat(item.isAvailable(), is(true));
    }

    @Test
    public void shouldPrintAStringRepresentationOfLibraryItem() {
        LibraryItem item = new LibraryItem("Title", 1997, 10);

        assertThat(item.toString(), is("title='Title', year=1997, isAvailable=true, rating=10\n"));
    }
}