package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Menu {


    private final Option option;
    private List<String> options;
    private PrintStream printStream;
    private InputReader inputReader;

    public Menu(List<String> options,
                PrintStream printStream,
                InputReader inputReader, Option option) {
        this.options = options;
        this.printStream = printStream;
        this.inputReader = inputReader;
        this.option = option;
    }

    public void launch() {
        displayOptions();
        prompt("Please select an option.");
        int optionNumber = inputReader.read();
        option.select(optionNumber);
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
}
