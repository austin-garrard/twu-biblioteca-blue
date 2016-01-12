package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    PrintStream printStream;
    List<String> books;
    Library library;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<String>();
        library = new Library(books, printStream);
    }

    @Test
    public void shouldPrintOneBooksWhenOnlyOneBook() {
        books.add("Moby Dick");

        library.listBooks();

        verify(printStream).println("Moby Dick");
    }

    @Test
    public void shouldPrintAllBooksWhenMultipleBooks() {
        books.add("Moby Dick");
        books.add("Count of Monte Cristo");

        library.listBooks();

        verify(printStream).println("Moby Dick\nCount of Monte Cristo");
    }
}
