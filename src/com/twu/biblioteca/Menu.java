package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Menu {


    private List<String> options;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Menu(Library library, List<String> options,
                PrintStream printStream,
                BufferedReader bufferedReader) {

        this.options = options;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void launch() {
        displayOptions();
        prompt("Please select an option.");
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

        try {
            bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
