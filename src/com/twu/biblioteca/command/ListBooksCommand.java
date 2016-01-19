package com.twu.biblioteca.command;

import com.twu.biblioteca.BooksList;

public class ListBooksCommand extends Command {


    private BooksList booksList;

    public ListBooksCommand(String name, BooksList booksList) {
        super(name);
        this.booksList = booksList;
    }

    @Override
    public void execute() {
        booksList.print();
    }
}
