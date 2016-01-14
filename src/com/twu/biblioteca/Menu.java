package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Menu {


    private List options;
    private PrintStream printStream;

    public Menu(List options, PrintStream printStream) {

        this.options = options;
        this.printStream = printStream;
    }

    public void launch() {
    }
}
