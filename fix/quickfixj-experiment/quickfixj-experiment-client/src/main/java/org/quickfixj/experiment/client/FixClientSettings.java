package org.quickfixj.experiment.client;

import java.io.InputStream;

import quickfix.ConfigError;
import quickfix.SessionSettings;

public class FixClientSettings {
    
    private static final String CONFIG_FILE_NAME = "config.properties";
    private final SessionSettings settings;

    public FixClientSettings() {
        try {
            this.settings = new SessionSettings(getClass().getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
        } catch (ConfigError e) {
            throw new RuntimeException(e);
        }
    }

    public SessionSettings getSettings() {
        return settings;
    }

}
