package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibrarianTest {

    @Test
    public void shouldGreetUserWhenLibraryOpens() {
        Library library = mock(Library.class);
        WelcomeUser welcomeUser = mock(WelcomeUser.class);
        Librarian librarian = new Librarian(library, welcomeUser);

        librarian.openLibrary();

        verify(welcomeUser).welcomeUser();
    }

    @Test
    public void shouldListBooksWhenLibraryOpens() {
        Library library = mock(Library.class);
        WelcomeUser welcomeUser = mock(WelcomeUser.class);
        Librarian librarian = new Librarian(library, welcomeUser);

        librarian.openLibrary();

        verify(library).listBooks();
    }

}