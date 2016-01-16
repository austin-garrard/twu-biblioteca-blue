package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

public class Menu {


    private Library library;
    private List<String> options;
    private PrintStream printStream;
    private InputReader inputReader;

    public Menu(Library library, List<String> options,
                PrintStream printStream,
                InputReader inputReader) {
        this.library = library;

        this.options = options;
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    public void launch() {
        displayOptions();
        prompt("Please select an option.");
        int option = inputReader.read();
        selectOption(option);
    }

    private void displayOptions() {
        int optionNum = 1;

        for (String option : options) {
            printStream.println("[" + optionNum + "] " + option);
            optionNum++;
        }
    }

    public void prompt(String phrase) {
        printStream.println(phrase);
    }

    public void selectOption(int option) {
        library.bookList();
    }

}
