package com.twu.biblioteca;

import com.twu.biblioteca.command.Command;

import java.io.PrintStream;
import java.util.Map;

public class Menu {

    private Map<Integer, Command> commandMap;
    private PrintStream printStream;
    private InputReader inputReader;

    public Menu(PrintStream printStream,
                InputReader inputReader, Map<Integer, Command> commandMap) {
        this.printStream = printStream;
        this.inputReader = inputReader;
        this.commandMap = commandMap;
    }

    public void launch() {
        displayOptions();
        int optionNumber = inputReader.read();
        executeCommand(optionNumber);
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
        for (Integer key : commandMap.keySet()) {
            printStream.println("[" + key + "] " + commandMap.get(key).getName());
        }

        printStream.println("Please select an option.");
    }

}
