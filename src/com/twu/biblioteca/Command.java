package com.twu.biblioteca;

public abstract class Command {
    private String name;

    public Command(String name) {
        this.name = name;
    }

    abstract void execute();

    public String getName() {
        return name;
    }
}
