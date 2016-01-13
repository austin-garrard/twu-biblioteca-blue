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

    private PrintStream printStream;
    private Book book;

    @Before
    public void setup() {

        printStream = mock(PrintStream.class);
        book = new Book("Dracula", "Bram Stoker", "1875", printStream);
    }

    @Test
    public void shouldPrintBookInformationWhenPrintDetailsIsCalled() {

        book.printDetails();
        verify(printStream).println(contains("Dracula"));

    }

    @Test
    public void shouldIncludeFullTitleInFormattedDetailsWhenTitleIsShorterThan25Chars(){
        assertThat(book.formattedDetails(), containsString("Dracula"));
    }

    @Test
    public void shouldIncludeTruncatedTitleInFormattedDetailsWhenTitleIsLongerThan25Chars(){
        Book longBook = new Book("A Really Way Too Long Title That Is Too Much", "Natalie", "1874", printStream);
        assertThat(longBook.formattedDetails(), containsString("A Really Way Too Long Tit..."));
    }

}
