package com.nexusuniverse.kairos.kairos;

public final class KairosState {
    private boolean active = true;
    private String message = "The Nexus is under observation.";

    public boolean active() { return active; }
    public String message() { return message; }

    public void setMessage(String message) { this.message = message; }
}
