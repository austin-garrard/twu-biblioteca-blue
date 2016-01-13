package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by smitchell on 1/13/16.
 */
public class Book {
    private String title;
    private String author;
    private String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String formattedDetails() {
        BookFormatter formatter = new BookFormatter();
        String formattedDetails = formatter.formatSubstring(title, 25) + formatter.formatSubstring(author, 25) + formatter.formatSubstring(year, 4);

        return formattedDetails;
    }
}
