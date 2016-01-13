package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibrarianTest {

    private Library library;
    private WelcomeUser welcomeUser;
    private Librarian librarian;


    @Before
    public void setup() {
        library = mock(Library.class);
        welcomeUser = mock(WelcomeUser.class);
        librarian = new Librarian(library, welcomeUser);
    }

    @Test
    public void shouldGreetUserWhenLibraryOpens() {
        librarian.openLibrary();

        verify(welcomeUser).welcomeUser();
    }

    @Test
    public void shouldListBooksWhenLibraryOpens() {
        librarian.openLibrary();

        verify(library).listBooks();
    }
}