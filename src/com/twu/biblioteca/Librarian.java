package com.twu.biblioteca;

import java.io.PrintStream;

public class Librarian {
    private Library library;
    private Menu menu;
    private PrintStream printStream;

    public Librarian(Library library, Menu menu, PrintStream printStream) {
        this.library = library;
        this.menu = menu;
        this.printStream = printStream;
    }

    public void openLibrary() {
        printStream.println("Welcome, user!");
        menu.launch();
        printStream.println("Menu: [1] Display Books");
    }
}
