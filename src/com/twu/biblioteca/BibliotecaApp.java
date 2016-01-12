package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<String> books = new ArrayList<String>();
        books.add("Dracula");
        books.add("Moby Dick");

        WelcomeUser welcomeUser = new WelcomeUser(System.out);
        Library library = new Library(books, System.out);
        Librarian librarian = new Librarian(library, welcomeUser);

        librarian.openLibrary();
    }
}
