package com.twu.biblioteca.command;

import com.twu.biblioteca.InputReader;
import com.twu.biblioteca.Library;

import java.io.PrintStream;

public class CheckoutBookCommand extends Command {

    private Library library;
    private PrintStream printStream;
    private InputReader inputReader;

    public CheckoutBookCommand(String name, Library library, PrintStream printStream, InputReader inputReader) {
        super(name);
        this.library = library;
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    @Override
    public void execute() {
        printStream.println("Enter the number of the book you wish to check out");
        library.bookList();
        int input = inputReader.read();
        library.checkoutBook(input - 1);
    }
}
