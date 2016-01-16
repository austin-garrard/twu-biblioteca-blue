package com.twu.biblioteca;

public class ApplicationState {
    private boolean active;

    public ApplicationState() {
        active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void setInactive() {
        active = false;
    }
}
