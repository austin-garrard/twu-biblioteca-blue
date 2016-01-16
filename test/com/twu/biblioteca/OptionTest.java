package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OptionTest {

    private Option option;
    private Library library;
    private PrintStream printStream;

    @Before
    public void setup() {
        library = mock(Library.class);
        printStream = mock(PrintStream.class);
        option = new Option(library, printStream);
    }

    @Test
    public void shouldListBooksWhenFirstOptionSelected() {
        option.select(1);

        verify(library).bookList();
    }

    @Test
    public void shouldDisplayMessageWhenSelectingInvalidOption() {
        option.select(-20);

        verify(printStream).println("Select a valid option!");
    }

}