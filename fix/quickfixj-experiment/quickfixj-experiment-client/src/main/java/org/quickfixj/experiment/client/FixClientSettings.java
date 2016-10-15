package org.quickfixj.experiment.client;

import quickfix.SessionSettings;

public class FixClientSettings {
    
    private final SessionSettings settings;

    public FixClientSettings() {
        this.settings = new SessionSettings();
    }

    public SessionSettings getSettings() {
        return settings;
    }

}
