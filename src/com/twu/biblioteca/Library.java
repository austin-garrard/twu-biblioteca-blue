package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<String> books;
    private PrintStream printStream;

    public Library(List<String> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void listBooks() {
        String listOfBooks = StringUtils.join(books, "\n");
        printStream.println(listOfBooks);
    }
}
