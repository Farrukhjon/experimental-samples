package org.farrukh.experiments.quickfixj.shared;

import org.farrukh.experiments.quickfixj.shared.exception.FixException;

import quickfix.ConfigError;
import quickfix.SessionSettings;

public class FixSettingsProvider {

    private static final String DEFAULT_CNFIG_FILE_NAME = "config.properties";

    public SessionSettings loadSettings(final String fileName) {
        String name = fileName;
        try {
            if (fileName == null || fileName.isEmpty()) {
                name = DEFAULT_CNFIG_FILE_NAME;
            }
            return new SessionSettings(getClass().getClassLoader().getResourceAsStream(name));
        } catch (ConfigError e) {
            throw new FixException(e);
        }
    }

}
