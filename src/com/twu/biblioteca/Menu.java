package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class Menu {

    private Map<Integer, Command> commandMap;
    private List<String> options;
    private PrintStream printStream;
    private InputReader inputReader;

    public Menu(List<String> options,
                PrintStream printStream,
                InputReader inputReader, Map<Integer, Command> commandMap) {
        this.options = options;
        this.printStream = printStream;
        this.inputReader = inputReader;
        this.commandMap = commandMap;
    }

    public void launch() {
        displayOptions();
        prompt("Please select an option.");
        int optionNumber = inputReader.read();
        if(commandMap.containsKey(optionNumber)) {
            commandMap.get(optionNumber).execute();
        }
        else {
            printStream.println("Select a valid option!");
        }
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
