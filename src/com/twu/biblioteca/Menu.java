package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Menu {


    private List<String> options;
    private PrintStream printStream;

    public Menu(List<String> options, PrintStream printStream) {

        this.options = options;
        this.printStream = printStream;
    }

    public void launch() {
        displayOptions();
        prompt("Please select an option.");
    }

    private void displayOptions() {
        for (int i = 0; i < options.size(); i++) {
            String option = options.get(i);
            int optionNum = i + 1;
            printStream.println("[" + optionNum + "] " + option);
        }
    }

    public void prompt(String phrase) {
        printStream.println(phrase);
    }
}
