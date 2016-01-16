package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class LibrarianTest {

    private Library library;
    private Menu menu;
    private PrintStream printStream;
    private Librarian librarian;
    private ApplicationState applicationState;


    @Before
    public void setup() {
        library = mock(Library.class);
        menu = mock(Menu.class);
        printStream = mock(PrintStream.class);
        applicationState = mock(ApplicationState.class);
        when(applicationState.isActive()).thenReturn(true).thenReturn(false);
        librarian = new Librarian(library, menu, printStream, applicationState);
    }

    @Test
    public void shouldGreetUserWhenLibraryOpens() {
        librarian.openLibrary();

        verify(printStream).println("Welcome, user!");
    }

    @Test
    public void shouldLaunchMenuWhenLibraryIsOpen() {
        librarian.openLibrary();
        verify(menu).launch();
    }

    @Test
    public void shouldNotLaunchMenuWhenLibraryIsClosed() {
        when(applicationState.isActive()).thenReturn(false);
        librarian.openLibrary();
        verify(menu, times(0)).launch();
    }
}