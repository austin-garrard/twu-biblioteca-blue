package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> books;
    private PrintStream printStream;

    public Library(List<Book> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void bookList() {
        Formatter formatter = new Formatter();
        String header = formatHeader(formatter);

        printStream.println(header);

        for (Book book: books) {
            printStream.println(book.formattedDetails());
        }
    }

    private String formatHeader(Formatter formatter) {
        return formatter.formatSubstring("Title", 25) + formatter.formatSubstring("Author", 25) + formatter.formatSubstring("Year", 4);
    }
}
