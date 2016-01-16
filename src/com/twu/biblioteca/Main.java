package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Book> books = bookList();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library(books, System.out);
        InputReader inputReader = new InputReader(bufferedReader);
        Menu menu = new Menu(library, menuOptions(), System.out, inputReader);
        Librarian librarian = new Librarian(library, menu, System.out);

        librarian.openLibrary();
    }

    private static List<Book> bookList() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Dracula", "Bram Stoker", "1875"));
        books.add(new Book("Moby Dick", "Sherman Melville", "1890"));
        return books;
    }

    private static List<String> menuOptions() {
        List<String> menuOptions = new ArrayList<>();
        menuOptions.add("List Books");

        return menuOptions;
    }
}
