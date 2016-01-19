package com.twu.biblioteca.command;

import com.twu.biblioteca.ApplicationState;

public class QuitCommand extends Command {
    private ApplicationState applicationState;

    public QuitCommand(String name, ApplicationState applicationState) {
        super(name);
        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        applicationState.setInactive();
    }
}
