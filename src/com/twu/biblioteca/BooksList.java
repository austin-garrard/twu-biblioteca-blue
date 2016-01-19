package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class BooksList {
    private List<Book> books;
    private PrintStream printStream;


    public BooksList(List<Book> books, PrintStream printStream) {

        this.books = books;
        this.printStream = printStream;
    }

    private String formatHeader(Formatter formatter) {
        return formatter.formatSubstring("Title", 25) + formatter.formatSubstring("Author", 25) + formatter.formatSubstring("Year", 4);
    }

    public void print() {
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

    public boolean isAvailable(int bookToRemove) {
        return bookToRemove >= 0 && bookToRemove < books.size();
    }


    public void remove(int bookToRemove) {
        books.remove(bookToRemove);
    }
}
