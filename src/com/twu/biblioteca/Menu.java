package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by smitchell on 1/13/16.
 */
public class Menu {
    private PrintStream printStream;

    public Menu(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void listOptions() {
        printStream.println("[1] List Books");
    }
}
