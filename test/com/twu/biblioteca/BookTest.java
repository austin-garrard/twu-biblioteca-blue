package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    @Test
    public void shouldPrintBookInformationWhenListDetailsIsCalled() {
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("Dracula", "Bram Stoker", "1875", printStream);

        book.listDetails();

        verify(printStream).println("Dracula\tBram Stoker\t1875");
    }
}
