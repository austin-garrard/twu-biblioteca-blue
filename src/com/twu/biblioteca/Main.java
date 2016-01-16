package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Library library = new Library(bookList(), printStream);
        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new ListBooksCommand(library));

        InputReader inputReader = new InputReader(bufferedReader);
        Menu menu = new Menu(menuOptions(), printStream, inputReader, commandMap);

        Librarian librarian = new Librarian(library, menu, printStream);

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
