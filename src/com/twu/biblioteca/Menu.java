package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {

    public ArrayList<String> getMenu() {
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1. View List of Books");
        menuOptions.add("2. Checkout a Book");
        return menuOptions;
    }

}
