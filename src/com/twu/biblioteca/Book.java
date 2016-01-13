package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by smitchell on 1/13/16.
 */
public class Book {
    private String title;
    private String author;
    private String year;
    private PrintStream printStream;

    public Book(String title, String author, String year, PrintStream printStream) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.printStream = printStream;
    }

    public void printDetails() {
        printStream.println(formattedDetails());
    }


    public String formattedDetails() {
        BookFormatter formatter = new BookFormatter();
        String formattedDetails = formatter.formatSubstring(title, 25) + formatter.formatSubstring(author, 25) + formatter.formatSubstring(year, 4);

        return formattedDetails;
    }
}
