package com.twu.biblioteca;

import java.io.PrintStream;

public class Librarian {
    private Library library;
    private PrintStream printStream;

    public Librarian(Library library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    public void openLibrary() {
        printStream.println("Welcome, user!");
        printStream.println(library.bookList());
    }
}
