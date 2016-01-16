package com.twu.biblioteca;

import java.io.PrintStream;

public class Option {
    private Library library;
    private PrintStream printStream;

    public Option(Library library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    public void select(int number) {
        switch (number) {
            case 1:
                library.bookList();
                break;
            default:
                printStream.println("Select a valid option!");
        }
    }
}
