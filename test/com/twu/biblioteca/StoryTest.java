package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StoryTest {

    @Test
    public void shouldPrintBook() {
        Library library = new Library();
        Story story = new Story();

        assertThat(story.printStory(library.bookshelf(), 0), is("Title: The Agile Samurai | Author: Jonathon Rasmusson | Published: 2010"));
    }


    @Test
    public void shouldPrintMovie() {
        Library library = new Library();
        Story story = new Story();

        assertThat(story.printStory(library.movieshelf(), 0), is("Title: First Man | Year: 2018 | Director: Damien Chazelle | Rating: 7"));
    }



}