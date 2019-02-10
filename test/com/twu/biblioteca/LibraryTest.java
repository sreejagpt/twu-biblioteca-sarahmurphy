package com.twu.biblioteca;

import com.sun.org.apache.bcel.internal.generic.LUSHR;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class LibraryTest {

    @Test
    public void shouldHaveAListOfBooks() {
        Library library = new Library();
        //assertThat(library.getListOfBooks(), is());

        //how do I check lists contain same elements?

        //assertThat(library.getListOfBooks(), contains(new Book("The Agile Samurai", "Jonathon Rasmusson", 2010));

    }
}