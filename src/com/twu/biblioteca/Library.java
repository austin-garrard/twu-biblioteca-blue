package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private PrintStream printStream;
    private  BooksList booksList;


    public Library(BooksList books, PrintStream printStream) {
        booksList = books;
        this.printStream = printStream;
    }



    public void checkoutBook(int bookToRemove) {
        if(booksList.isAvailable(bookToRemove)) {
            booksList.remove(bookToRemove);
            printStream.println("Thank you! Enjoy the book");
        }
        else {
            printStream.println("That book is not available.");
        }
    }
}
