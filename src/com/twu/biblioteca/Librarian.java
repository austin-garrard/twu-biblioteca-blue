package com.twu.biblioteca;

import java.io.PrintStream;

public class Librarian {
    private Menu menu;
    private PrintStream printStream;
    private ApplicationState applicationState;

    public Librarian(Menu menu, PrintStream printStream, ApplicationState applicationState) {
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
