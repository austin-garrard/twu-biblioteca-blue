package com.twu.biblioteca;

import java.io.PrintStream;

public class Librarian {
    private Library library;
    private Menu menu;
    private PrintStream printStream;
    private ApplicationState applicationState;

    public Librarian(Library library, Menu menu, PrintStream printStream, ApplicationState applicationState) {
        this.library = library;
        this.menu = menu;
        this.printStream = printStream;
        this.applicationState = applicationState;
    }

    public void openLibrary() {
        printStream.println("Welcome, user!");

        while (applicationState.isActive()) {
            menu.launch();
        }
    }
}
