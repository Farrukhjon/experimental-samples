package org.farrukh.examples.log4j;

import static org.apache.log4j.Level.ERROR;
import static org.apache.log4j.Level.FATAL;
import static org.apache.log4j.Level.WARN;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class RollingFileAppenderDemo {

    private final Logger logger = Logger.getLogger(RollingFileAppenderDemo.class);

    private void logDebug() {
        logger.debug("Hello world by debug message");
    }

    private void logInfo() {
        logger.info("Hello world by info message");
    }

    private void logWarn() {
        logger.warn("Hello world by warn message");
    }

    private void logError() {
        logger.error("Hello world by error message");
    }

    private void logFatal() {
        logger.fatal("Hello world by fatal message");
    }

    public RollingFileAppenderDemo() {
        if (logger.isDebugEnabled())
            logDebug();
        if (logger.isInfoEnabled())
            logInfo();
        if (logger.isEnabledFor(WARN))
            logWarn();
        if (logger.isEnabledFor(ERROR))
            logError();
        if (logger.isEnabledFor(FATAL))
            logFatal();
    }

    public static void main(String[] args) {
        while (true) {
            new RollingFileAppenderDemo();
        }
    }

}
