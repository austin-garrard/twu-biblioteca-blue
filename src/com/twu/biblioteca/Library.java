package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public void listBooks() {
        for (Book book: books) {
            book.printDetails();
        }
    }
}
