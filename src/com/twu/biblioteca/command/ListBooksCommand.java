package com.twu.biblioteca.command;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.command.Command;

public class ListBooksCommand extends Command {

    private Library library;

    public ListBooksCommand(String name, Library library) {
        super(name);
        this.library = library;
    }

    @Override
    public void execute() {
        library.bookList();
    }
}
