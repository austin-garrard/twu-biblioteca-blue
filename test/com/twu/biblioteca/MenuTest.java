package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private Menu menu;
    private Library testLibrary;
    private List<String> testOptions;
    private PrintStream testStream;
    private BufferedReader testReader;
    private InputReader inputReader;

    @Before
    public void setup() {

        testLibrary = mock(Library.class);
        testOptions = new ArrayList<>();
        testStream = mock(PrintStream.class);
        testReader = mock(BufferedReader.class);
        inputReader = mock(InputReader.class);

        menu = new Menu(testLibrary, testOptions, testStream, inputReader);
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

    @Test
    public void shouldReadInputWhenLaunching() {
        menu.launch();

        verify(inputReader).read();
    }

    @Test
    public void shouldExecuteOptionWhenLaunching() {
        menu.launch();

        verify(testLibrary).bookList();
    }


    @Test
    public void shouldListBooksWhenFirstOptionSelected() {
        menu.selectOption(1);

        verify(testLibrary).bookList();
    }

    @Test
    public void shouldDisplayMessageWhenSelectingInvalidOption() {
        menu.selectOption(-20);

        verify(testStream).println("Select a valid option!");
    }
}
