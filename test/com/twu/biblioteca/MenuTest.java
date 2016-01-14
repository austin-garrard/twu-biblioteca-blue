package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private PrintStream testStream;
    private List testOptions;
    private Menu menu;

    @Before
    public void setup() {

        testStream = mock(PrintStream.class);
        testOptions = new ArrayList<String>();
        menu = new Menu(testOptions, testStream);
    }

    @Test
    public void shouldDisplayOptionsAtLaunch() {
        testOptions.add("Option 1");

        menu.launch();

        verify(testStream).println(contains("Option 1"));
    }

    @Test
    public void shouldPromptUserToSelectAnOptionAtLaunch() {
        testOptions.add("Option 1");

        menu.launch();

        verify(testStream).println(contains("Please select an option."));
    }

    @Test
    public void shouldEnumerateOptionsWhenDisplayingThem() {
        testOptions.add("Some option");

        menu.launch();

        verify(testStream).println("[1] Some option");
    }

    @Test
    public void shouldDisplayPromptToUserWhenGettingInput() {
        menu.prompt("Type Something:");

        verify(testStream).println("Type Something:");
    }
}
