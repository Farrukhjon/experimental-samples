package org.farrukh.examples.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentB {

    private final Logger logger = LoggerFactory.getLogger(ComponentB.class);

    public ComponentB() {
        logger.info("Starting initiating of component {}", this);
    }
}
