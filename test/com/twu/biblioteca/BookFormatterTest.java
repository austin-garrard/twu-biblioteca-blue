package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookFormatterTest {

    private BookFormatter bookFormatter;

    @Before
    public void setup() {

        bookFormatter = new BookFormatter();
    }

    @Test
    public void shouldTruncateStringWhenStringGreaterThanLimit() {
        String formattedBook = bookFormatter.formatSubstring("Harry Potter and the Sorcerer's Stone", 25);
       assertThat(formattedBook, is("Harry Potter and the Sorc...  "));
    }

    @Test
    public void shouldTruncateStringWhenStringLessThanLimit() {

        String formattedBook = bookFormatter.formatSubstring("Dracula", 25);
        assertThat(formattedBook, is("Dracula                       "));
    }


}
