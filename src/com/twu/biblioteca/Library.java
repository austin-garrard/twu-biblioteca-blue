package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> books;
    private PrintStream printStream;
    private InputReader inputReader;

    public Library(List<Book> books, PrintStream printStream, InputReader inputReader) {
        this.books = books;
        this.printStream = printStream;
        this.inputReader = inputReader;
    }

    public void bookList() {
        Formatter formatter = new Formatter();
        String header = formatHeader(formatter);

        printStream.println(header);
        int bookNumber = 1;

        for (Book book: books) {
            printStream.println("[" + bookNumber + "] " + book.formattedDetails());
            bookNumber++;
        }

        printStream.println();
    }

    private String formatHeader(Formatter formatter) {
        return formatter.formatSubstring("Title", 25) + formatter.formatSubstring("Author", 25) + formatter.formatSubstring("Year", 4);
    }

    public void checkoutBook(int bookToRemove) {
        books.remove(bookToRemove);
    }
}
