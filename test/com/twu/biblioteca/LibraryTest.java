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
import static org.mockito.Mockito.when;

public class LibraryTest {

    PrintStream printStream;
    List<Book> books;
    Library library;
    Book bookOne;
    Book bookTwo;
    private InputReader inputReader;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        inputReader = mock(InputReader.class);
        bookOne = mock(Book.class);
        bookTwo = mock(Book.class);

        books = new ArrayList<>();
        library = new Library(books, printStream, inputReader);
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
}
