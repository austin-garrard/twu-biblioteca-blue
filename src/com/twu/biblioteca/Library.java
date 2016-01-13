package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public void listBooks() {
        for (Book book: books) {
            book.listDetails();
        }
    }
}
