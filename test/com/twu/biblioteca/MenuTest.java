package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class MenuTest {

    private Menu menu;
    private List<String> testOptions;
    private PrintStream testStream;
    private InputReader inputReader;
    private Map<Integer, Command> commandMap;


    @Before
    public void setup() {
        testOptions = new ArrayList<>();
        testStream = mock(PrintStream.class);
        inputReader = mock(InputReader.class);
        commandMap = new HashMap<>();

        menu = new Menu(testOptions, testStream, inputReader, commandMap);
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
    public void shouldReadInputWhenLaunching() {
        menu.launch();

        verify(inputReader).read();
    }

    @Test
    public void shouldExecuteValidOptionWhenLaunching() {
        when(inputReader.read()).thenReturn(1);
        ListBooksCommand listBooksCommand = mock(ListBooksCommand.class);
        commandMap.put(1, listBooksCommand);

        menu.launch();

        verify(listBooksCommand).execute();
    }

    @Test
    public void shouldDisplayMessageWhenSelectingInvalidOption() {
        menu.launch();

        verify(testStream).println("Select a valid option!");
    }
}
