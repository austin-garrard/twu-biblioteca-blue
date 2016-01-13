package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibrarianTest {

    private Library library;
    private PrintStream printStream;
    private Librarian librarian;


    @Before
    public void setup() {
        library = mock(Library.class);
        printStream = mock(PrintStream.class);
        librarian = new Librarian(library, printStream);
    }

    @Test
    public void shouldGreetUserWhenLibraryOpens() {
        librarian.openLibrary();

        verify(printStream).println("Welcome, user!");
    }

    @Test
    public void shouldListBooksWhenLibraryOpens() {
        librarian.openLibrary();

        verify(library).bookList();
    }
}