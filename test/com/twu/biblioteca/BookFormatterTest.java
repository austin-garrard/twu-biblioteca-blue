package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookFormatterTest {

    @Test
    public void shouldTruncateStringWhenStringGreaterThanLimit() {
        BookFormatter bookFormatter = new BookFormatter();
        String formattedBook = bookFormatter.formatSubstring("Harry Potter and the Sorcerer's Stone", 25);
       assertThat(formattedBook, is("Harry Potter and the Sorc...  "));
    }

    @Test
    public void shouldTruncateStringWhenStringLessThanLimit() {
        BookFormatter bookFormatter = new BookFormatter();
        String formattedBook = bookFormatter.formatSubstring("Dracula", 25);
        assertThat(formattedBook, is("Dracula                       "));
    }
}
