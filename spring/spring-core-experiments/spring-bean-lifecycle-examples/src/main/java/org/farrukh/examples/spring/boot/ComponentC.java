package org.farrukh.examples.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class ComponentC {

    private final Logger logger = LoggerFactory.getLogger(ComponentC.class);

    public ComponentC() {
        logger.info("Starting initiating of component {}", this);
    }

    @PostConstruct
    public void startMethods() {
        logger.info("Starting method annotated with @PostConstruct ");
    }
}
