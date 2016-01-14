package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    @Test
    public void shouldDisplayOptionsAtLaunch() {
        PrintStream testStream = mock(PrintStream.class);
        List testOptions = new ArrayList<String>();
        testOptions.add("Option 1");

        Menu menu = new Menu(testOptions, testStream);
        menu.launch();

        verify(testStream).println(contains("Option 1"));
    }
}
