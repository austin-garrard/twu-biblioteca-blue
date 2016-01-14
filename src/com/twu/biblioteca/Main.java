package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Book> books = bookList();

        Library library = new Library(books);
        Menu menu = new Menu(menuOptions(), System.out);
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
