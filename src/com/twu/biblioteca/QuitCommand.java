package com.twu.biblioteca;

public class QuitCommand implements Command {
    private ApplicationState applicationState;

    public QuitCommand(ApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public void execute() {
        applicationState.setInactive();
    }
}
