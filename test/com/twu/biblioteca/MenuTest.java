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
    private ApplicationState applicationState;


    @Before
    public void setup() {
        testOptions = new ArrayList<>();
        testStream = mock(PrintStream.class);
        inputReader = mock(InputReader.class);
        commandMap = new HashMap<>();
        applicationState = mock(ApplicationState.class);
        when(applicationState.isActive()).thenReturn(true).thenReturn(false);

        menu = new Menu(testOptions, testStream, inputReader, commandMap, applicationState);
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

    @Test
    public void shouldNotDisplayOptionsWhenNotActive() {
        when(applicationState.isActive()).thenReturn(false);

        menu.launch();

        verify(testStream, times(0)).println(anyString());
    }

    @Test
    public void shouldNotReadInputWhenNotActive() {
        when(applicationState.isActive()).thenReturn(false);

        menu.launch();

        verify(inputReader, times(0)).read();
    }

    @Test
    public void shouldNotDisplayMessageForInvalidCommandWhenNotActive() {
        when(applicationState.isActive()).thenReturn(false);

        menu.launch();

        verify(testStream, times(0)).println(anyString());
    }

    @Test
    public void shouldNotExecuteCommandWhenNotActive() {
        when(applicationState.isActive()).thenReturn(false);
        when(inputReader.read()).thenReturn(1);
        ListBooksCommand listBooksCommand = mock(ListBooksCommand.class);
        commandMap.put(1, listBooksCommand);

        menu.launch();

        verify(listBooksCommand, times(0)).execute();
    }

}
