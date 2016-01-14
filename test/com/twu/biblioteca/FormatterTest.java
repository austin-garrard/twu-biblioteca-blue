package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FormatterTest {

    private Formatter formatter;

    @Before
    public void setup() {

        formatter = new Formatter();
    }

    @Test
    public void shouldTruncateStringWhenStringGreaterThanLimit() {
        String formattedBook = formatter.formatSubstring("Harry Potter and the Sorcerer's Stone", 25);
       assertThat(formattedBook, is("Harry Potter and the Sorc...  "));
    }

    @Test
    public void shouldTruncateStringWhenStringLessThanLimit() {

        String formattedBook = formatter.formatSubstring("Dracula", 25);
        assertThat(formattedBook, is("Dracula                       "));
    }


}
