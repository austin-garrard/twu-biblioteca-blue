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
    List<Book> books;
    Library library;
    Book bookOne;
    Book bookTwo;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);

        books = new ArrayList<Book>();
        library = new Library(books);
    }

    @Test
    public void shouldPrintOneBooksWhenOnlyOneBook() {
        books.add(bookOne);

        library.listBooks();

        verify(bookOne).printDetails();
    }

    @Test
    public void shouldPrintFirstBookWhenMultipleBooksExist() {
        books.add(bookOne);
        books.add(bookTwo);

        library.listBooks();

        verify(bookOne).printDetails();
    }

    @Test
    public void shouldPrintSecondBookWhenMultipleBooksExist() {
        books.add(bookOne);
        books.add(bookTwo);

        library.listBooks();

        verify(bookTwo).printDetails();
    }
}
