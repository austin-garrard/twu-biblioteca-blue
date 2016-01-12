package com.twu.biblioteca;


import org.junit.Test;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WelcomeUserTest {

    @Test
    public void testUserSeesWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        WelcomeUser welcomeUser = new WelcomeUser(printStream);
        welcomeUser.welcomeUser();

        verify(printStream).println("Welcome, user!");
    }
}
