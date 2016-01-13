package com.twu.biblioteca;

import java.io.PrintStream;

public class WelcomeUser {

    private PrintStream printStream;

    public WelcomeUser(PrintStream printStream){
        this.printStream = printStream;
    }

    public void welcomeUser() {
        printStream.println("Welcome, user!");
    }
}
