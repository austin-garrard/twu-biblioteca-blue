package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class Menu {

    private Map<Integer, Command> commandMap;
    private ApplicationState applicationState;
    private List<String> options;
    private PrintStream printStream;
    private InputReader inputReader;

    public Menu(List<String> options,
                PrintStream printStream,
                InputReader inputReader, Map<Integer, Command> commandMap, ApplicationState applicationState) {
        this.options = options;
        this.printStream = printStream;
        this.inputReader = inputReader;
        this.commandMap = commandMap;
        this.applicationState = applicationState;
    }

    public void launch() {
        while(applicationState.isActive()) {
            displayOptions();
            int optionNumber = inputReader.read();
            executeCommand(optionNumber);
        }
    }

    private void executeCommand(int optionNumber) {
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

        printStream.println("Please select an option.");
    }

}
