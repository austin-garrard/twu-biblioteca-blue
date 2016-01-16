package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private Menu menu;
    private List<String> testOptions;
    private PrintStream testStream;
    private InputReader inputReader;
    private Option option;

    @Before
    public void setup() {
        testOptions = new ArrayList<>();
        testStream = mock(PrintStream.class);
        inputReader = mock(InputReader.class);
        option = mock(Option.class);

        menu = new Menu(testOptions, testStream, inputReader, option);
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

        verify(option).select(anyInt());
    }
}
