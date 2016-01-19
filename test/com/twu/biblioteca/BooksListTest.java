package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BooksListTest {


    private BooksList booksList;
    private Book bookOne;
    private Book bookTwo;
    private PrintStream printStream;

    @Before
    public void setup() {
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);
        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        printStream = mock(PrintStream.class);

        booksList = new BooksList(books, printStream);
    }


    @Test
    public void shouldReturnOneFormattedBooksStringWhenOnlyOneBook() {
        booksList.print();

        verify(bookOne).formattedDetails();
    }


    @Test
    public void shouldReturnSecondFormattedBookWhenMultipleBooksExist() {
        booksList.print();

        verify(bookTwo).formattedDetails();
    }

}
