package com.twu.biblioteca;

import java.io.PrintStream;

public class Librarian {
    private Library library;
    private PrintStream printStream;

    public Librarian(Library library, Menu menu, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    public void openLibrary() {
        printStream.println("Welcome, user!");
        printStream.println("Menu: [1] Display Books");
    }

    public void menuSelect(int optionNumber){
        printStream.println(library.bookList());
    }
}
