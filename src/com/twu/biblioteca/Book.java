package com.twu.biblioteca;

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
        Formatter formatter = new Formatter();
        String formattedDetails = formatter.formatSubstring(title, 25) + formatter.formatSubstring(author, 25) + formatter.formatSubstring(year, 4);

        return formattedDetails;
    }
}
