package org.farrukh.experiments.quickfixj.shared;

import org.farrukh.experiments.quickfixj.shared.exception.FixException;

import quickfix.ConfigError;
import quickfix.SessionSettings;

public class FixSettingsProvider {

    private String defaultCnfigFileName = "config.properties";

    public SessionSettings loadSettings(final String fileName) {
        String name = fileName;
        try {
            if (fileName == null || fileName.isEmpty()) {
                name = this.defaultCnfigFileName;
            }
            return new SessionSettings(getClass().getClassLoader().getResourceAsStream(name));
        } catch (ConfigError e) {
            throw new FixException(e);
        }
    }

}
