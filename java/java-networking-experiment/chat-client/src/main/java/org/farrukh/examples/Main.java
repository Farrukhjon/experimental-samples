package org.farrukh.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entry point class for main application.
 */
@SuppressWarnings({"checkstyle:hideutilityclassconstructor", "checkstyle:javadocmethod", "checkstyle:constantname"})
public final class Main {

    /**
     * Logger backed by logback framework.
     */
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) {
        logger.debug("Running Main class...");
        MainWindow.getInstance();
    }

}
