package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckoutBookTest {

    @Test
    public void enteredBookTitleShouldMatchBookListTitle() {
        BookList bookList = new BookList();
        ArrayList<Book> listOfAvailableBooks = bookList.getListOfBooks();

        String bookToCheckout = "The Agile Samurai";

        for (int i = 0; i<listOfAvailableBooks.size(); i++) {
            assertThat(listOfAvailableBooks.get(i).getTitle(), is((bookToCheckout)));
            break;
        }
    }

    @Test
    public void shouldCheckoutGivenBookFromLibrary() {
        System.out.println("Please enter the title of the book you wish to checkout.");
        String bookToCheckout = "The Agile Samurai";
        BookList bookList = new BookList();
        ArrayList<Book> listOfAvailableBooks = bookList.getListOfBooks();

        for (int i = 0; i < listOfAvailableBooks.size(); i++) {
            assertThat(listOfAvailableBooks.get(i).getTitle(), is((bookToCheckout)));
            if(listOfAvailableBooks.get(i).getTitle().equalsIgnoreCase(bookToCheckout)) {
                listOfAvailableBooks.remove(i);
                break;
            }
        }

        for (int j = 0; j < listOfAvailableBooks.size(); j++) {
            assertThat(listOfAvailableBooks.get(j).getBook(), is(not(bookToCheckout)));
        }
    }

}
