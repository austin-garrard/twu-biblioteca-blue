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
    public void shouldReturnOneFormattedBooksStringWhenOnlyOneBook() {
        books.add(bookOne);

        library.bookList();

        verify(bookOne).formattedDetails();
    }


    @Test
    public void shouldReturnSecondFormattedBookWhenMultipleBooksExist() {
        books.add(bookOne);
        books.add(bookTwo);

        library.bookList();

        verify(bookTwo).formattedDetails();
    }
}
