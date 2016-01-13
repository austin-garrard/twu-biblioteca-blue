package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public String bookList() {
        String bookList = "";

        for (Book book: books) {
            bookList += book.formattedDetails() + "\n";
        }

        return bookList;
    }
}
