package org.farrukh.examples.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentA {

    private final Logger logger = LoggerFactory.getLogger(ComponentA.class);

    public ComponentA() {
        logger.info("Starting initiating of component {}", this);
    }
}
