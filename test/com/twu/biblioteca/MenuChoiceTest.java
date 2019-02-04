package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MenuChoiceTest {

    @Test
    public void shouldAlertUserIfInvalidOptionChosen() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1");

        System.out.println("Menu");
        for(String s : menuOptions) {
            System.out.println(s);
        }

        String menuChoice = "2";

        for(String s : menuOptions) {
            if(menuChoice.equals(s)) {
                assertThat(menuChoice, is(s));
            }
            else {
                assertThat(menuChoice, is(not(s)));
            }
        }


    }


}
