package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    PrintStream printStream;
    List<Book> books;
    Library library;
    Book bookOne;
    Book bookTwo;
    private InputReader inputReader;
    private BooksList booksList;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        inputReader = mock(InputReader.class);
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);

        books = new ArrayList<>();
        booksList = new BooksList(books, printStream);
        library = new Library(booksList, printStream);
    }

    @Test
    public void shouldCheckoutBookWhenSingleBook() {
        books.add(bookOne);

        library.checkoutBook(0);

        assertThat(books.size(), is(0));
    }

    @Test
    public void shouldCheckoutBookWhenMultipleBooks() {
        books.add(bookOne);
        books.add(bookTwo);

        library.checkoutBook(1);

        assertThat(books.get(0), is(bookOne));

    }

    @Test
    public void shouldPrintSuccessMessageWhenCheckoutOutBook() {
        books.add(bookOne);

        library.checkoutBook(0);

        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldPrintNotAvailableWhenInvalidBookNumber() {
        books.add(bookOne);

        library.checkoutBook(1);

        verify(printStream).println("That book is not available.");
    }
}
