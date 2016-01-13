package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    private Book book;

    @Before
    public void setup() {

        book = new Book("Dracula", "Bram Stoker", "1875");
    }

    @Test
    public void shouldIncludeFullTitleInFormattedDetailsWhenTitleIsShorterThan25Chars(){
        assertThat(book.formattedDetails(), containsString("Dracula"));
    }

    @Test
    public void shouldIncludeTruncatedTitleInFormattedDetailsWhenTitleIsLongerThan25Chars(){
        Book longBook = new Book("A Really Way Too Long Title That Is Too Much", "Natalie", "1874");
        assertThat(longBook.formattedDetails(), containsString("A Really Way Too Long Tit..."));
    }

}
