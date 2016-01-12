package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldPrintOneBooksWhenOnlyOneBook() {
        PrintStream printStream = mock(PrintStream.class);
        List<String> books = new ArrayList<String>();

        books.add("Moby Dick");

        Library library = new Library(books, printStream);

        library.listBooks();

        verify(printStream).println("Moby Dick");
    }

    @Test
    public void shouldPrintAllBooksWhenMultipleBooks() {
        PrintStream printStream = mock(PrintStream.class);
        List<String> books = new ArrayList<String>();

        books.add("Moby Dick");
        books.add("Count of Monte Cristo");

        Library library = new Library(books, printStream);

        library.listBooks();

        verify(printStream).println("Moby Dick\nCount of Monte Cristo");
    }
}
