package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    @Test
    public void shouldPrintOptionsWhenListOptionsIsCalled() {
        PrintStream printStream = mock(PrintStream.class);
        Menu menu = new Menu(printStream);

        menu.listOptions();

        verify(printStream).println("[1] List Books");
    }
}
