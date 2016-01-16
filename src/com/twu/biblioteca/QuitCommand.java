package com.twu.biblioteca;

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
