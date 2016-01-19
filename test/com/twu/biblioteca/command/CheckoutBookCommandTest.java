package com.twu.biblioteca.command;


import com.twu.biblioteca.InputReader;
import com.twu.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;


import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class CheckoutBookCommandTest {

    PrintStream printStream;
    Library library;
    private InputReader inputReader;
    private CheckoutBookCommand checkoutBookCommand;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        inputReader = mock(InputReader.class);
        library =mock(Library.class);
        checkoutBookCommand= new CheckoutBookCommand("checkout", library, printStream, inputReader);
    }

    @Test
    public void shouldPromptUserWhenCheckingOutBook() {
        checkoutBookCommand.execute();
        verify(printStream).println("Enter the number of the book you wish to check out");
    }

    @Test
    public void shouldDisplayBookListWhenCheckingOutBook() {
        checkoutBookCommand.execute();
        verify(library).bookList();
    }

    @Test
    public void shouldReadBookNumberFromUserWhenCheckingOutBook() {
        checkoutBookCommand.execute();
        verify(inputReader).read();
    }

    @Test
    public void shouldCheckOutBook() {
        checkoutBookCommand.execute();
        verify(library).checkoutBook(anyInt());
    }

}