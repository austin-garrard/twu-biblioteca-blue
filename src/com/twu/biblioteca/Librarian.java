package com.twu.biblioteca;

public class Librarian {
    private Library library;
    private WelcomeUser welcomeUser;

    public Librarian(Library library, WelcomeUser welcomeUser) {
        this.library = library;
        this.welcomeUser = welcomeUser;
    }

    public void openLibrary() {
        welcomeUser.welcomeUser();
        library.listBooks();
    }
}
